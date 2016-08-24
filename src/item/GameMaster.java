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
//	private Masu prevMasu;


	public void checkNifu(Board b){
		// 未実装
	}

	public void checkNaru(Board b){
		Masu m = b.getDstMasu();

		if (m.getKoma().isDirection() == true) {
			if (m.getPoint().y <= 3) {
				m.getKoma().naru();
				b.putKoma(m.getPoint().x, m.getPoint().y, m.getKoma());
			}
		} else {
			if (m.getPoint().y >= 7) {
				m.getKoma().naru();
				b.putKoma(m.getPoint().x, m.getPoint().y, m.getKoma());
			}
		}
	}


	// 指定した駒の移動可能位置をtrueに変更
	public void createMap(Board shogiBoard) {

		Masu src = shogiBoard.getSrcMasu();
		Koma koma = src.getKoma();

		ArrayList<Point> pList = (ArrayList<Point>)koma.getMoveList(src.getPoint());

		// 移動可能判断
		/*
		// 駒が移動先にある場合
		if (masu.isExistKoma() == true) {
			// 移動先の駒が自駒の場合
			if (masu.getKoma().isDirection() == GameMaster.getTurn()) {
				return list;
			// 移動先の駒が敵駒の場合
			} else {
				list.add(new Point(p.x, i));
				return list;
			}
		}
		 */

		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).x < 1 || pList.get(i).x > 9)
				continue;
			if (pList.get(i).y < 1 || pList.get(i).y > 9)
				continue;

			Masu masu = shogiBoard.getMasu(pList.get(i));
			// trueをセット
			masu.setPlaceable(true);
		}
	}

	public void deleteMap(Board shogiBoard) {
		for (int i = 0; i < View.SIZE * View.SIZE; i++) {
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
		System.out.println(""+masu.getPoint().x + masu.getPoint().y + masu.getKoma());

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
