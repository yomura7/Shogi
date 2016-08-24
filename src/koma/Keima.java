package koma;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Keima extends Koma {

	private static String[] name = { "./koma_img/sgs06.png",
			"./koma_img/sgs36.png", "./koma_img/sgs16.png",
			"./koma_img/sgs46.png" };

	public Keima(boolean direction) {
		super(direction, name);
	}

	public List<Point> getMoveList(Point p) {
		List<Point> list = new ArrayList<Point>();

		if (face == true) { // 表の動き
			if (direction == true) {
				list.add(new Point(p.x - 1, p.y - 2));
				list.add(new Point(p.x + 1, p.y - 2));
			} else {
				list.add(new Point(p.x - 1, p.y + 2));
				list.add(new Point(p.x + 1, p.y + 2));
			}
			return list;
		} else { // 裏の動き
			Kin narikei = new Kin(direction);
			return narikei.getMoveList(p);
		}
	}

}
