package item;

import java.awt.Color;

// TODO View に統合

public class Draw{



	static public void coloring(Masu m) {
		View.getMasu(m.getIndex()).setColor(Color.CYAN);
	}

	/* 駒台の描画 */
	public void drawKomadai(){

	}

	public void updateKomadai(){

	}


	/* 盤の着色 */
	static public void coloringMap() {
		// 移動可能位置の着色
		for (int i = 0; i < (View.SIZE * View.SIZE); i++) {
			Masu masu = View.getMasu(i);
			if (masu.getPlaceable() == true) {
				View.getMasu(i).setColor(Color.ORANGE);
			}else{
				View.getMasu(i).setColor(Color.DARK_GRAY);
			}
		}
		// 指定駒の着色
//		Board.getMasu(m.getIndex()).setColor(Color.CYAN);
	}



}
