package com.example.item;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import com.exmaple.koma.Koma;

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
		// 盤上駒リスナー
		for (int i = 0; i < Board.SIZE * Board.SIZE; i++) {
			shogiBoard.getMasu(i).addMouseListener(this);
		}
		// 持ち駒リスナー
		for (int i = 0; i < Komadai.KOMADAI_SIZE; i++) {
			shogiBoard.getKomadai(0).getMochigoma(i).addMouseListener(this);
			shogiBoard.getKomadai(1).getMochigoma(i).addMouseListener(this);
		}

	}

	// クリック時のマスを受け取っていろいろ処理
	public void clickOnBoard(Masu masu){

		Koma koma = masu.getKoma();

		// クリック1度目・・・配置可能位置を着色
		if (GM.getClickFlag() == false) {
			shogiBoard.setSrcMasu(null);
			// 駒が存在 && 選択した駒とターンが一致
			if (masu.isExistKoma() == true && GM.getTurn() == koma.isDirection()) {
				// srcマスをセット
				shogiBoard.setSrcMasu(masu);
				// クリックした駒の配置可能マップ生成
				GM.createMap(shogiBoard, 0);
				// クリック状態に変更
				GM.invertFlag();

			} else {
				shogiBoard.setSrcMasu(null);
				GM.deleteMap(shogiBoard);
			}
			// Viewに変更通知
			setChanged();
			notifyObservers(shogiBoard);
			return;
		}

		// クリック2度目・・・着色をリセット =============

		// 移動可能範囲にある場合
		if (masu.getPlaceable() == true) {
			// 駒を動かす
			if (shogiBoard.getKomadaiNum() == -1) {
				moveKoma(masu);
			// 駒を打つ
			} else {
				utsuKoma(masu);
			}
		}

		// srcをリセット
		shogiBoard.setSrcMasu(null);
		shogiBoard.setKomadaiNum(-1);
		// クリック状態を解除
		GM.invertFlag();
		GM.deleteMap(shogiBoard);

		setChanged();
		notifyObservers(shogiBoard);
	}

	private void utsuKoma(Masu masu) {
		int x = masu.getPoint().x;
		int y = masu.getPoint().y;

		// 配置先にコマがある場合
		if (masu.isExistKoma() == true) {
			return;
		}

		int num = shogiBoard.getKomadaiNum();

		KomaGenerator kg = new KomaGenerator();
		Koma k;
		if (GM.getTurn() == true) {
			shogiBoard.getKomadai(0).removeMochigoma(num);
			k = kg.genKoma(num);
		} else {
			shogiBoard.getKomadai(1).removeMochigoma(num);
			k = kg.genKoma(num);
			k.turnDirection();
		}

		shogiBoard.putKoma(x, y, k);

		GM.deleteMap(shogiBoard);
		GM.changeTurn();
//		GM.message(shogiBoard.getKomadaiMasu());

	}

	public void moveKoma(Masu dst) {
		Masu src = shogiBoard.getSrcMasu();
		int x = dst.getPoint().x;
		int y = dst.getPoint().y;

		// 移動先に駒がある場合は駒を取り除く
		if (dst.isExistKoma() == true) {
			System.out.println("駒を取りました");

			// 反転
			dst.getKoma().turnDirection();

			shogiBoard.putKomadai(GM.getTurn(), dst.getKoma());
			dst.setKoma(null);
		}
		// 移動先に配置
		shogiBoard.putKoma(x, y, src.getKoma());
		// 移動元を削除
		shogiBoard.removeKoma(src.getPoint().x, src.getPoint().y);
		// 移動先の駒成りチェック
		GM.checkNaru(shogiBoard, shogiBoard.getMasu(new Point(x, y)) );

		shogiBoard.setLatestMasu(dst);

		GM.changeTurn();
		GM.message(dst);

	}


	// クリック時のマスを受け取っていろいろ処理
	public void clickOnKomadai(int num){

		// クリック２回目
		if (GM.getClickFlag() == true) {
			System.out.println("reset");

			shogiBoard.setSrcMasu(null);
			shogiBoard.setKomadaiNum(-1);
			GM.deleteMap(shogiBoard);

			setChanged();
			notifyObservers(shogiBoard);

			GM.invertFlag();
			return;
		}

		// クリック1回目 ------------------------------

		if (GM.getTurn() == true) {
			if (shogiBoard.getKomadai(0).getKomaNum(num) == 0){
				shogiBoard.setKomadaiNum(-1);
				return;
			}
		} else {
			if (shogiBoard.getKomadai(1).getKomaNum(num) == 0){
				shogiBoard.setKomadaiNum(-1);
				return;
			}
		}

		// クリックしたマスを取得
		shogiBoard.setKomadaiNum(num);
		// クリックした駒の配置可能マップ生成
		GM.createMap(shogiBoard, 1);
		// クリック状態に変更
		GM.invertFlag();
		// Viewに変更通知
		setChanged();
		notifyObservers(shogiBoard);

	}

	public Board getShogiBoard() {
		return shogiBoard;
	}

	@Override
	public void mousePressed(MouseEvent e) {

		// クリックした座標のマスを取得
		Masu m = (Masu)e.getSource();

		if (m.getName() == null) {
			clickOnBoard(m);
		} else {
			int num = Integer.parseInt(m.getName());
			if (GM.getTurn() == true) {
				if (num >= 0 && num <= Komadai.KOMADAI_SIZE ) {
					clickOnKomadai(num);
				}
			} else if (GM.getTurn() == false) {
				if (num >= 10 && num <= Komadai.KOMADAI_SIZE+10 ) {
					num %= 10;
					clickOnKomadai(num);
				}
			}
		}
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
