package koma;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Kin extends Koma {

	private static String[] name ={
		"./koma_img/sgs04.png",
		"./koma_img/sgs34.png",
	};

	public Kin(boolean direction) {
		super(direction, name);
	}

	public List<Point> getMoveList(Point p) {
		List<Point> list = new ArrayList<Point>();

		if (direction == true) {
			list.add(new Point(p.x, p.y - 1));
			list.add(new Point(p.x - 1, p.y - 1));
			list.add(new Point(p.x + 1, p.y - 1));
			list.add(new Point(p.x - 1, p.y));
			list.add(new Point(p.x + 1, p.y));
			list.add(new Point(p.x, p.y + 1));
		} else {
			list.add(new Point(p.x, p.y + 1));
			list.add(new Point(p.x - 1, p.y + 1));
			list.add(new Point(p.x + 1, p.y + 1));
			list.add(new Point(p.x - 1, p.y));
			list.add(new Point(p.x + 1, p.y));
			list.add(new Point(p.x, p.y - 1));
		}
		return list;
	}


}
