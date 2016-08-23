package item;

import java.awt.Point;
import java.util.Observable;

// 盤面の状態を表すクラス

// Masuだけで事足りる可能性あり→その場合は削除

public class State extends Observable{

	private Masu[] masu = new Masu[View.SIZE * View.SIZE];


	// コンストラクタ
	public State() {

		for (int i = 0; i < masu.length; i++) {
			masu[i] = new Masu(i);
		}
	}

	/* Getter */
	public Masu getMasu(int index) {
		return masu[index];
	}

	public Masu getMasu(Point p) {
		if (p.x < 1 || p.x > 9) return null;
		if (p.y < 1 || p.y > 9) return null;
		return masu[point2index(p)];
	}

	/* 盤座標と通し番号の変換 */
	// 盤座標→通し番号
	static public int point2index(Point p) {
		return ((9 - p.x) + ((p.y - 1) * 9));
	}

	// 通し番号→盤座標
	static public Point index2point(int index) {
		int y = (index / 9) + 1;
		int x = 9 - (index % 9);
		return new Point(x, y);
	}



}
