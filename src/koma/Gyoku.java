package koma;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Gyoku extends Koma {

	private static String[] name = { "./koma_img/sgs01.png",
			"./koma_img/sgs31.png" };

	public Gyoku(boolean direction) {
		super(direction, name);
	}

	public List<Point> getMoveList(Point p) {
		List<Point> list = new ArrayList<Point>();

		list.add(new Point(p.x, p.y - 1));
		list.add(new Point(p.x - 1, p.y - 1));
		list.add(new Point(p.x + 1, p.y - 1));
		list.add(new Point(p.x - 1, p.y));
		list.add(new Point(p.x + 1, p.y));
		list.add(new Point(p.x, p.y + 1));
		list.add(new Point(p.x - 1, p.y + 1));
		list.add(new Point(p.x + 1, p.y + 1));

		return list;
	}

}
