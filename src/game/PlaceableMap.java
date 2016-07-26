package game;

import java.awt.Point;
import java.util.ArrayList;

// 配置可能マップクラス：駒が移動できる位置を決めるためのクラス
public class PlaceableMap {

	private boolean[] map = new boolean[Board.SIZE * Board.SIZE];
//	private Point komaPoint;
	private Masu masu;
	private int index;
	private Point komaPoint;

	public PlaceableMap(Masu masu) {
		super();
		this.masu = masu;
		this.komaPoint = masu.getPoint();
		this.index = Board.point2index(masu.getPoint());
		// ラベルの初期化
		for (int i = 0; i < Board.SIZE*Board.SIZE; i++) {
			map[i] = false;
		}
	}

	public void createMap(){
		// 指定した駒の移動可能位置をtrueに変更
//		Point komaPoint = m.getPoint();
		ArrayList<Point>pList = masu.getKoma().getMoveList(komaPoint);
		for (int i=0; i<pList.size(); i++){

			System.out.println("isExist = " + masu.isExistKoma());
			if (pList.get(i).x < 1 || pList.get(i).x > 9) continue;
			if (pList.get(i).y < 1 || pList.get(i).y > 9) continue;
//			if (m.isExistKoma() == false) continue;

			int id = Board.point2index(pList.get(i));
			map[id] = true;
			System.out.println("id = "+id);
		}
	}

	public int getIndex(){
		return index;
	}

	public boolean[] getMap() {
		return map;
	}


}
