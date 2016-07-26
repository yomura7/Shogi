package koma;

import java.awt.Point;
import java.util.ArrayList;


public class Gyoku extends Koma {

	private static String[] name = {
		"./koma_img/sgs01.png",
		"./koma_img/sgs31.png",
		"./koma_img/sgs01.png",
		"./koma_img/sgs31.png"
	};

	public Gyoku(boolean face, boolean direction) {
		super(face, direction, name);
	}

	@Override
	public ArrayList<Point> getMoveList(Point p){
		ArrayList<Point> list = new ArrayList<Point>();
		if (direction == true) {
			list.add(new Point(p.x, p.y - 1));
			list.add(new Point(p.x - 1, p.y - 1));
			list.add(new Point(p.x + 1, p.y - 1));
			list.add(new Point(p.x - 1, p.y));
			list.add(new Point(p.x + 1, p.y));
			list.add(new Point(p.x, p.y + 1));
			list.add(new Point(p.x - 1, p.y + 1));
			list.add(new Point(p.x + 1, p.y + 1));
		} else {
			list.add(new Point(p.x, p.y - 1));
			list.add(new Point(p.x - 1, p.y - 1));
			list.add(new Point(p.x + 1, p.y - 1));
			list.add(new Point(p.x - 1, p.y));
			list.add(new Point(p.x + 1, p.y));
			list.add(new Point(p.x, p.y + 1));
			list.add(new Point(p.x - 1, p.y + 1));
			list.add(new Point(p.x + 1, p.y + 1));
		}
		return list;
	}

}
