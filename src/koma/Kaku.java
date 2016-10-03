package koma;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Kaku extends Koma {

	private static String[] imgName ={
		"./koma_img/sgs03.png",
		"./koma_img/sgs33.png",
		"./koma_img/sgs13.png",
		"./koma_img/sgs43.png"
	};
	private static String[] komaName = {
		"角", "馬"
	};

	public Kaku(boolean direction) {
		super(direction, imgName, komaName);
	}

	public List<Point> getMoveList(Point p) {
		List<Point> list = new ArrayList<Point>();

		for(int i=1; i<=9; i++){
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
