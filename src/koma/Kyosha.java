package koma;

import game.Board;
import game.GameMaster;
import game.Masu;

import java.awt.Point;
import java.util.ArrayList;

public class Kyosha extends Koma {

	private static String[] name = { "./koma_img/sgs07.png",
			"./koma_img/sgs37.png", "./koma_img/sgs17.png",
			"./koma_img/sgs47.png" };

	public Kyosha(boolean direction) {
		super(direction, name);
	}

	@Override
	public ArrayList<Point> getMoveList(Point p) {
		ArrayList<Point> list = new ArrayList<Point>();

		if (direction == true) {
			for (int i = p.y - 1; i >= 1; i--) {
				Masu masu = Board.getMasu(new Point(p.x, i));
				// 駒が移動先にある場合
				if (masu.isExistKoma() == true) {
					// 移動先の駒が自駒の場合
					if (masu.getKoma().isDirection() == GameMaster.getTurn()) {
						return list;
					// 移動先の駒が敵駒の場合
					} else {
						list.add(new Point(p.x, i));
						return list;
					}
				}
				list.add(new Point(p.x, i));
			}
		} else {
			for (int i = p.y + 1; i <= Board.SIZE; i++) {
				Masu masu = Board.getMasu(new Point(p.x, i));
				// 駒が移動先にある場合
				if (masu.isExistKoma() == true) {
					// 移動先の駒が自駒の場合
					if (masu.getKoma().isDirection() == GameMaster.getTurn()) {
						return list;
					// 移動先の駒が敵駒の場合
					} else {
						list.add(new Point(p.x, i));
						return list;
					}
				}
				list.add(new Point(p.x, i));
			}
		}

		return list;
	}

}
