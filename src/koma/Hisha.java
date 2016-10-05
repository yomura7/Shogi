package koma;

import item.Board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Hisha extends Koma {

	private static String[] imgName ={
		"./koma_img/sgs02.png",
		"./koma_img/sgs32.png",
		"./koma_img/sgs12.png",
		"./koma_img/sgs42.png"
	};
	private static String[] komaName = {
		"飛", "龍"
	};

	public Hisha(boolean direction) {
		super(direction, imgName, komaName);
	}

	public List<Point> getMoveList(Point p) {
		List<Point> list = new ArrayList<Point>();

		for(int i=1; i<=Board.SIZE; i++){
			list.add(new Point(p.x, i));
			list.add(new Point(i, p.y));
		}

		if (face == false) {
			list.add(new Point(p.x - 1, p.y - 1));
			list.add(new Point(p.x + 1, p.y - 1));
			list.add(new Point(p.x - 1, p.y + 1));
			list.add(new Point(p.x + 1, p.y + 1));
		}

		return list;
	}
}
