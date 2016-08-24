package item;

import java.util.Observable;
import java.util.Observer;

import koma.Koma;

/* MVCモデル - Controller */
//マウスイベント時の処理を定義するクラス

public class Controller  implements Observer {

	private Board shogiBoard;
	private View UI;
	private GameMaster GM;
	private KomaListener[] listener = new KomaListener[View.SIZE * View.SIZE];

	// コンストラクタ
	public Controller(){

		// 将棋盤の生成・駒の初期配置
		this.shogiBoard = new Board();

		Setting setting = new Setting(Setting.HIRATE);
		setting.initPlace(shogiBoard);

		// Listenerの設定
		for (int i = 0; i < View.SIZE*View.SIZE; i++) {
			listener[i].addObserver(this);
			shogiBoard.getMasu(i).addMouseListener(listener[i]);
		}

		// UIの生成
		this.UI = new View();
		UI.setMainField(shogiBoard);
		UI.setVisible(true);

		GM = new GameMaster();

	}


	// クリック時のマスを受け取っていろいろ処理
	public void update(Observable o, Object arg){
		// 引数を受け取る
		Masu masu = new Masu();
		masu = (Masu)arg;
		Koma koma = masu.getKoma();

		// クリック1度目・・・配置可能位置を着色
		if (GM.getClickFlag() == false) {
			// 駒が存在 && 選択した駒とターンが一致
			if (masu.isExistKoma() == true &&
				GM.getTurn() == koma.isDirection()) {

				shogiBoard.setSrcMasu(masu);

				// クリックした駒の配置可能マップ生成
				GM.createMap(shogiBoard);
				GM.invertFlag();

				// 描画
				UI.coloringMap(shogiBoard);
			}
		// クリック2度目・・・着色をリセット
		} else {
			shogiBoard.setDstMasu(masu);

			moveKoma(shogiBoard);

			GM.deleteMap(shogiBoard);
			GM.invertFlag();

			// 描画
			UI.coloringMap(shogiBoard);
		}
	}

	public void moveKoma(Board board) {

		Masu src = board.getSrcMasu();
		Masu dst = board.getDstMasu();


		if (dst.getPlaceable() == true) {

			// 移動先に駒がある場合
			if (dst.isExistKoma() == true) {
					System.out.println("駒を取りました");
			}

			// 移動先に配置
			board.putKoma(dst.getPoint().x, dst.getPoint().y, src.getKoma());
			System.out.println("Koma = " + src.getKoma());
			// 移動元を削除
			src.removeKoma();

			GM.checkNaru(shogiBoard);
			GM.changeTurn();
			GM.message();

		}
	}


}
