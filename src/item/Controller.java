package item;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import koma.Koma;

/* MVCモデル - Controller */
//マウスイベント時の処理を定義するクラス

public class Controller extends Observable implements MouseListener{

	private Board shogiBoard;
	private GameMaster GM  = new GameMaster();

	// コンストラクタ
	public Controller(){

		// 将棋盤の生成・駒の初期配置
		this.shogiBoard = new Board();

		Setting setting = new Setting(Setting.HIRATE);
		setting.initPlace(shogiBoard);

		// Listenerの設定
		for (int i = 0; i < View.SIZE*View.SIZE; i++) {
			shogiBoard.getMasu(i).addMouseListener(this);
		}
	}


	// クリック時のマスを受け取っていろいろ処理
	public void clicked(Masu masu){

		Koma koma = masu.getKoma();

		// クリック1度目・・・配置可能位置を着色
		if (GM.getClickFlag() == false) {
			// 駒が存在 && 選択した駒とターンが一致
			if (masu.isExistKoma() == true && GM.getTurn() == koma.isDirection()) {

				// srcマスをセット
				shogiBoard.setSrcMasu(masu);

				// クリックした駒の配置可能マップ生成
				GM.createMap(shogiBoard);

				// Viewに変更通知
				setChanged();
				notifyObservers(shogiBoard);

				// クリック状態に変更
				GM.invertFlag();
			}

		// クリック2度目・・・着色をリセット
		} else {

			// dstマスをセット
			shogiBoard.setDstMasu(masu);

			// 駒を移動
			moveKoma();

			GM.deleteMap(shogiBoard);

			// dstを着色するために一時的にsrcに設定
			shogiBoard.setSrcMasu(shogiBoard.getDstMasu());

			// Viewに変更通知
			setChanged();
			notifyObservers(shogiBoard);

			// src, dstをリセット
			shogiBoard.setSrcMasu(null);
			shogiBoard.setDstMasu(null);

			// クリック状態を解除
			GM.invertFlag();

		}

	}

	public void moveKoma() {

		Masu src = shogiBoard.getSrcMasu();
		Masu dst = shogiBoard.getDstMasu();

		if (dst.getPlaceable() == true) {

			// 移動先に駒がある場合
			if (dst.isExistKoma() == true) {
				System.out.println("駒を取りました");
//				shogiBoard.putKomadai(GM.getTurn(), dst.getKoma());
			}

			// 移動先に配置
			shogiBoard.putKoma(dst.getPoint().x, dst.getPoint().y, src.getKoma());

			// 移動元を削除
			src.removeKoma();

			GM.checkNaru(shogiBoard);
			GM.changeTurn();
			GM.message(dst);

		}
	}



	public Board getShogiBoard() {
		return shogiBoard;
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// クリックした座標のマスを取得
		Masu m = (Masu)e.getSource();
		clicked(m);
	}

	// 実装なし
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}
}
