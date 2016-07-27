package game;

import java.awt.Point;
import java.util.ArrayList;

public class GameMaster {

	static private boolean clickFlag = false;
	static private boolean turn = true;
	static private Masu prevMasu;

	// 指定した駒の移動可能位置をtrueに変更
	static public void createMap(ArrayList<Point> pList){

		for (int i=0; i<pList.size(); i++){
			if (pList.get(i).x < 1 || pList.get(i).x > 9) continue;
			if (pList.get(i).y < 1 || pList.get(i).y > 9) continue;

			Masu masu = Board.getMasu(pList.get(i));
			if (masu.isExistKoma() == true) continue;

			// trueをセット
			masu.setPlaceable();
		}
	}

	static public void deleteMap(){
		for (int i=0; i<Board.SIZE*Board.SIZE; i++){
			Masu masu = Board.getMasu(i);
			masu.resetPlaceable();
		}
	}

	/* クリックフラグ管理 */
	static public boolean getClickFlag(){
		return clickFlag;
	}
	static public void invertFlag(){
		clickFlag = !clickFlag;
	}

	/* ターン管理 */
	static public boolean getTurn(){
		return turn;
	}
	static public void changeTurn(){
		turn = !turn;
	}

	/* 直前手の管理 */
	static public Masu getPrevMasu(){
		return prevMasu;
	}
	static public void setPrevMasu(Masu m){
		prevMasu = m;
	}

	static public void message(){
		if (GameMaster.getTurn() == true) {
			System.out.println("△先手番です");
		} else {
			System.out.println("▲後手番です");
		}
	}
}
