package koma;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Fu extends Koma {

	private static String[] name = { "./koma_img/sgs08.png",
			"./koma_img/sgs38.png", "./koma_img/sgs18.png",
			"./koma_img/sgs48.png" };

	public Fu(boolean direction) {
		super(direction, name);
	}

	public List<Point> getMoveList(Point p) {

		List<Point> list = new ArrayList<Point>();
		if (face == true) { // 表の動き
			if (direction == true) {
				list.add(new Point(p.x, p.y - 1));
			} else {
				list.add(new Point(p.x, p.y + 1));
			}
			return list;

		} else { // 裏の動き
			Kin tokin = new Kin(direction);
			return tokin.getMoveList(p);
		}
	}

}
