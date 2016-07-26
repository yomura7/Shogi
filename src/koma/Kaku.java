package koma;

import java.awt.Point;
import java.util.ArrayList;


public class Kaku extends Koma {

	private static String[] name ={
		"./koma_img/sgs03.png",
		"./koma_img/sgs33.png",
		"./koma_img/sgs13.png",
		"./koma_img/sgs43.png"
	};

	public Kaku(boolean face, boolean direction) {
		super(face, direction, name);
	}

	@Override
	public ArrayList<Point> getMoveList(Point p){
		ArrayList<Point> list = new ArrayList<Point>();

		// 右上・右下
		for(int i=0; i<=9; i++){
			if (p.x - i >= 1 && p.y - i >= 1){		// 右上
				list.add(new Point( p.x - i, p.y - i ));
			}
			if (p.x - i >= 1 && p.y + i <= 9){		// 右下
				list.add(new Point( p.x - i, p.y + i ));
			}
			if (p.x + i <= 9 && p.y - i >= 1){		// 左上
				list.add(new Point( p.x + i, p.y - i ));
			}
			if (p.x + i <= 9 && p.y + i <= 9){		// 左下
				list.add(new Point( p.x + i, p.y + i ));
			}
		}

		return list;
	}

}
