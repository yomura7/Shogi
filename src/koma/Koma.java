package koma;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Koma {

	protected String imgName;
	protected boolean face;
	protected boolean direction;
	protected ArrayList<Point> list = new ArrayList<Point>();

	// コンストラクタ
	public Koma(boolean face, boolean direction, String[] name) {
		super();
		this.face = face;
		this.direction = direction;

		if (face == true && direction == true) {
			this.imgName = name[0];
		} else if (face == true && direction == false) {
			this.imgName = name[1];
		} else if (face == false && direction == true) {
			this.imgName = name[2];
		} else if (face == false && direction == false) {
			this.imgName = name[3];
		}

	}

	// 配置可能マップの取得
	public ArrayList<Point> getMoveList(Point p) {
		ArrayList<Point> list = new ArrayList<Point>();
		return list;
	}

	public String getImgName() {
		return imgName;
	}

	public boolean isDirection() {
		return direction;
	}

}
