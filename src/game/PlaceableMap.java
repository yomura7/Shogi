package game;

import java.awt.Point;
import java.util.ArrayList;

// 配置可能マップクラス：駒が移動できる位置を決めるためのクラス
public class PlaceableMap {

	private boolean[] map1d = new boolean[Board.SIZE * Board.SIZE];
	private Point komaPoint;
	private int index;

	public PlaceableMap(Masu m) {
		super();
		this.komaPoint = m.getPoint();
		this.index = Board.point2index(komaPoint);

		// ラベルの初期化
		for (int i = 0; i < Board.SIZE*Board.SIZE; i++) {
			map1d[i] = false;
		}
	}

	public void createMap(Masu m){
		// 指定した駒の移動可能位置をtrueに変更
//		Point komaPoint = m.getPoint();
		ArrayList<Point>list = m.getKoma().getPlaceablePoint(komaPoint);
		for(int i=0; i<list.size(); i++){
			int id = Board.point2index(list.get(i));
			map1d[id] = true;
			System.out.println("id = "+id);
		}
	}

	public boolean[] getMap() {
		return map1d;
	}
	public int getIndex() {
		return index;
	}


}
