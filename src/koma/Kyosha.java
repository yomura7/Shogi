package koma;

import game.Board;

import java.awt.Point;
import java.util.ArrayList;


public class Kyosha extends Koma {

	private static String[] name ={
		"./koma_img/sgs07.png",
		"./koma_img/sgs37.png",
		"./koma_img/sgs17.png",
		"./koma_img/sgs47.png"
	};

	public Kyosha(boolean face, boolean direction) {
		super(face, direction, name);
	}

	@Override
	public ArrayList<Point> getMoveList(Point p){
		ArrayList<Point> list = new ArrayList<Point>();

		if (direction == true) {
			for(int i=p.y; i>=1; i--){
				list.add(new Point(p.x, i));
			}
		} else {
			for(int i=p.y; i<=Board.SIZE; i++){
				list.add(new Point(p.x, i));
			}
		}

		return list;
	}


}
