package koma;

import game.Board;

import java.awt.Point;
import java.util.ArrayList;


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

	@Override
	public ArrayList<Point> getMoveList(Point p){
		ArrayList<Point> list = new ArrayList<Point>();

		for(int i=1; i<=Board.SIZE; i++){
			list.add(new Point(p.x, i));
			list.add(new Point(i, p.y));
		}

		return list;
	}
}
