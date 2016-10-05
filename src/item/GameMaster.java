package item;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

import koma.Koma;

// Controllerの補助
// このクラスにはルールなどを入れておく

public class GameMaster extends Observable{

	private boolean clickFlag = false;
	private boolean turn = true;

	public void checkNaru(Board b, Masu dst){

		if (turn == true) {
			if (dst.getPoint().y <= 3) {
//				System.out.println("y = "+dst.getPoint().y);
				Koma k = b.getMasu(dst.getPoint()).getKoma();
				k.naru();
				b.putKoma(dst.getPoint().x, dst.getPoint().y, k);
			}
		} else {
			if (dst.getPoint().y >= 7) {
//				System.out.println("y = "+dst.getPoint().y);
				Koma k = b.getMasu(dst.getPoint()).getKoma();
				k.naru();
				b.putKoma(dst.getPoint().x, dst.getPoint().y, k);
			}
		}
	}


	// 指定した駒の移動可能位置をtrueに変更
	public void createMap(Board shogiBoard, int process) {

		if (process == 0) {
			Masu src = shogiBoard.getSrcMasu();
			Koma koma = src.getKoma();

			ArrayList<Point> pList = (ArrayList<Point>)koma.getMoveList(src.getPoint());

			// 移動可能判断
			for (int i = 0; i < pList.size(); i++) {
				int x = pList.get(i).x;
				int y = pList.get(i).y;
				Masu masu = shogiBoard.getMasu(pList.get(i));

				// 移動先が盤外の場合
				if (x < 1 || x > 9)
					continue;
				if (y < 1 || y > 9)
					continue;
				// 自駒が移動先にある場合
				if (masu.isExistKoma() == true && masu.getKoma().isDirection() == turn)
					continue;
				// trueをセット
				masu.setPlaceable(true);
			}
		} else if (process == 1) {

			KomaGenerator kg = new KomaGenerator();
			Koma myKoma = kg.genKoma(shogiBoard.getKomadaiNum());

			// 歩を打つ場合は二歩のチェックを行う
			boolean nifuFlag[] = new boolean[Board.SIZE];
			if (myKoma.getKomaName() == "歩") {
				nifuFlag = checkNifu(shogiBoard);
			}

			// 移動可能マスに移動可能状態を付加
			for (int x = 1; x <= Board.SIZE; x++) {
				for (int y = 1; y <= Board.SIZE; y++) {
					Masu masu = shogiBoard.getMasu(new Point(x, y));

					if (masu.isExistKoma() == true) {
						continue;
					}
					if (nifuFlag[x-1] == true) {
						continue;
					}
					if (checkCanMove(myKoma, y) == false) {
						continue;
					}

					// trueをセット
					masu.setPlaceable(true);
				}
			}
		}
	}

	private boolean[] checkNifu(Board shogiBoard){
		boolean nifuFlag[] = new boolean[Board.SIZE];
		for (int x = 1; x <= Board.SIZE; x++) {
			for (int y = 1; y <= Board.SIZE; y++) {
				Masu masu = shogiBoard.getMasu(new Point(x, y));
				// 駒がある場合
				if (masu.isExistKoma() == true) {
					Koma k = shogiBoard.getMasu(new Point(x, y)).getKoma();
					// 自分の歩がある場合
					if (k.getKomaName() == "歩" && k.isDirection() == turn) {
						nifuFlag[x-1] = true;
					}
				}
			}
		}
		return nifuFlag;
	}

	// 配置先の駒が移動できる場合はtrue, 移動できない禁じ手の場合はfalse
	private boolean checkCanMove(Koma myKoma, int y){
		if (myKoma.getKomaName() == "歩") {
			if (turn == true && y == 1) {
				return false;
			} else if (turn == false && y == 9) {
				return false;
			} else {
				return true;
			}
		} else if (myKoma.getKomaName() == "香") {
			if (turn == true && y == 1) {
				return false;
			} else if (turn == false && y == 9) {
				return false;
			} else {
				return true;
			}
		} else if (myKoma.getKomaName() == "桂") {
			if (turn == true && y <= 2) {
				return false;
			} else if (turn == false && y >= 8) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

	public void deleteMap(Board shogiBoard) {
		for (int i = 0; i < Board.SIZE * Board.SIZE; i++) {
			shogiBoard.getMasu(i).setPlaceable(false);
		}
	}

	/* メッセージ表示 */
	public void message(Masu masu) {
		if (turn == true) {
			System.out.print("△");
		} else {
			System.out.print("▲");
		}
		System.out.println(""+masu.getPoint().x + masu.getPoint().y + masu.getKoma().getKomaName());

	}

	/* クリックフラグ管理 */
	public boolean getClickFlag() {
		return clickFlag;
	}
	public void invertFlag() {
		clickFlag = !clickFlag;
	}

	/* ターン管理 */
	public boolean getTurn() {
		return turn;
	}

	public void changeTurn() {
		turn = !turn;
	}

}
