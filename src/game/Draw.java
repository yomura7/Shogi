package game;

import java.awt.Color;

public class Draw {

	/* 盤の着色 */
	static public void coloringPlaceableMap(PlaceableMap m) {
		// 指定駒の着色
		Board.getMasu(m.getIndex()).setColor(Color.CYAN);
		// 移動可能位置の着色
		for (int i = 0; i < (Board.SIZE * Board.SIZE); i++) {
			if (m.getMap()[i] == true) {
				Board.getMasu(i).setColor(Color.ORANGE);
			}
		}

	}
	// 着色のクリア
	static public void clearPlaceableMap() {
		for (int i = 0; i < (Board.SIZE * Board.SIZE); i++) {
			Board.getMasu(i).setColor(Color.DARK_GRAY);
		}
	}

}
