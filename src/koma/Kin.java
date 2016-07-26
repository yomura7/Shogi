package koma;

import java.awt.Point;
import java.util.ArrayList;


public class Kin extends Koma {

	private static String[] name ={
		"./koma_img/sgs04.png",
		"./koma_img/sgs34.png",
		"./koma_img/sgs04.png",
		"./koma_img/sgs34.png"
	};

	public Kin(boolean face, boolean direction) {
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
