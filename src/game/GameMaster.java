package game;

import java.awt.Point;
import java.util.ArrayList;

public class GameMaster {

	static private boolean clickFlag = false;
	static private Masu prevMasu;

	// 指定した駒の移動可能位置をtrueに変更
	static public void createMap(ArrayList<Point> pList){

		for (int i=0; i<pList.size(); i++){
			Masu masu = Board.getMasu(pList.get(i));
			if (pList.get(i).x < 1 || pList.get(i).x > 9) continue;
			if (pList.get(i).y < 1 || pList.get(i).y > 9) continue;
//			if (masu.isExistKoma() == false) continue;

			// trueをセット
			masu.setPlaceable();
			System.out.println("Create Map");
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

	static public Masu getPrevMasu(){
		return prevMasu;
	}
	static public void setPrevMasu(Masu m){
		prevMasu = m;
	}

}
