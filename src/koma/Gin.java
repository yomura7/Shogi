package koma;

import java.awt.Point;
import java.util.ArrayList;

public class Gin extends Koma {

	private static String[] name = { "./koma_img/sgs05.png",
			"./koma_img/sgs35.png", "./koma_img/sgs15.png",
			"./koma_img/sgs45.png" };

	public Gin(boolean direction) {
		super(direction, name);
	}

	@Override
	public ArrayList<Point> getMoveList(Point p) {
		ArrayList<Point> list = new ArrayList<Point>();

		if (face == true) { // 表の動き
			if (direction == true) {
				list.add(new Point(p.x, p.y - 1));
				list.add(new Point(p.x - 1, p.y - 1));
				list.add(new Point(p.x + 1, p.y - 1));
				list.add(new Point(p.x - 1, p.y + 1));
				list.add(new Point(p.x + 1, p.y + 1));
			} else {
				list.add(new Point(p.x, p.y + 1));
				list.add(new Point(p.x - 1, p.y + 1));
				list.add(new Point(p.x + 1, p.y + 1));
				list.add(new Point(p.x - 1, p.y - 1));
				list.add(new Point(p.x + 1, p.y - 1));
			}
			return list;
		} else {	// 裏の動き
			Kin narigin = new Kin(direction);
			return narigin.getMoveList(p);
		}

	}

}
