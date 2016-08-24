package koma;

import item.View;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Hisha extends Koma {

	private static String[] name ={
		"./koma_img/sgs02.png",
		"./koma_img/sgs32.png",
		"./koma_img/sgs12.png",
		"./koma_img/sgs42.png"
	};

	public Hisha(boolean direction) {
		super(direction, name);
	}

	public List<Point> getMoveList(Point p) {
		List<Point> list = new ArrayList<Point>();

		for(int i=1; i<=View.SIZE; i++){
			list.add(new Point(p.x, i));
			list.add(new Point(i, p.y));
		}

		return list;
	}
}
