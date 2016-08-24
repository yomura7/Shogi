package item;

import java.awt.Point;
import java.util.List;
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
		Koma koma = shogiBoard.getSrcMasu().getKoma();
		List<Point> pList = koma.getMoveList(shogiBoard);

		// 移動可能判断


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
			shogiBoard.getDstMasu().setPlaceable(false);
		}
	}

	/* メッセージ表示 */
	public void message() {
		if (turn == true) {
			System.out.println("△先手番です");
		} else {
			System.out.println("▲後手番です");
		}
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
