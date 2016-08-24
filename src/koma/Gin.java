package koma;

import item.Board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Gin extends Koma {

	private static String[] name = { "./koma_img/sgs05.png",
			"./koma_img/sgs35.png", "./koma_img/sgs15.png",
			"./koma_img/sgs45.png" };

	public Gin(boolean direction) {
		super(direction, name);
	}

	public List<Point> getMoveList(Board b) {
		List<Point> list = new ArrayList<Point>();
		Point p = b.getSrcMasu().getPoint();

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
