package koma;

import java.awt.Point;
import java.util.ArrayList;


public class Fu extends Koma {

	private static String[] name ={
		"./koma_img/sgs08.png",
		"./koma_img/sgs38.png",
		"./koma_img/sgs18.png",
		"./koma_img/sgs48.png"
	};

	public Fu(boolean face, boolean direction) {
		super(face, direction, name);
	}

	@Override
	public ArrayList<Point> getMoveList(Point p){
		ArrayList<Point> list = new ArrayList<Point>();
		if (direction == true) {
			list.add(new Point(p.x, p.y - 1));
		} else {
			list.add(new Point(p.x, p.y + 1));
		}
		return list;
	}

}
