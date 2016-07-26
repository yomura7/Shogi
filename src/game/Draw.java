package game;

import java.awt.Color;

public class Draw {

	static public void coloring(Masu m) {
		Board.getMasu(m.getIndex()).setColor(Color.CYAN);
	}

	/* 盤の着色 */
	static public void coloringMap() {
		// 移動可能位置の着色
		for (int i = 0; i < (Board.SIZE * Board.SIZE); i++) {
			Masu masu = Board.getMasu(i);
			if (masu.getPlaceable() == true) {
				Board.getMasu(i).setColor(Color.ORANGE);
			}
		}
		// 指定駒の着色
//		Board.getMasu(m.getIndex()).setColor(Color.CYAN);
	}
}
