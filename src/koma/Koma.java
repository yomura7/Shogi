package koma;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Koma {

	protected String komaName;
	protected String imgName;
	protected boolean face;
	protected boolean direction;
	protected ArrayList<Point> list = new ArrayList<Point>();

	// コンストラクタ
	public Koma(boolean face, boolean direction) {
		super();
		this.face = face;
		this.direction = direction;

		// TODO ここでサブクラスから名前をもってくる

	}

	// 配置可能マップの取得
	// TODO 今は全部の駒が歩の動作をしている
	// TODO 駒ごとにオーバーライドするか、このメソッドを抽象メソッドにする
	public ArrayList<Point> getPlaceablePoint(Point p) {

		// 駒の動きを追加
		if (direction == true) {
			list.add(new Point(p.x, p.y - 1));
		} else {
			list.add(new Point(p.x, p.y + 1));
		}
		return list;
	}

	public String getKomaName() {
		return komaName;
	}
	public String getImgName() {
		return imgName;
	}

}
