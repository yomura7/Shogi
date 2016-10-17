package com.exmaple.koma;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Kin extends Koma {

	private static String[] imgName ={
		"./koma_img/sgs04.png",
		"./koma_img/sgs34.png",
	};
	private static String[] komaName = {
		"金", "金"
	};
	public Kin(boolean direction) {
		super(direction, imgName, komaName);
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
