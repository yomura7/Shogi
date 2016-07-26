package koma;

import java.awt.Point;
import java.util.ArrayList;


public class Keima extends Koma {

	private static String[] name ={
		"./koma_img/sgs06.png",
		"./koma_img/sgs36.png",
		"./koma_img/sgs16.png",
		"./koma_img/sgs46.png"
	};

	public Keima(boolean face, boolean direction) {
		super(face, direction, name);
	}

	@Override
	public ArrayList<Point> getMoveList(Point p){
		ArrayList<Point> list = new ArrayList<Point>();
		if (direction == true) {
			list.add(new Point(p.x - 1, p.y - 2));
			list.add(new Point(p.x + 1, p.y - 2));
		} else {
			list.add(new Point(p.x - 1, p.y + 2));
			list.add(new Point(p.x + 1, p.y + 2));
		}
		return list;
	}

}
