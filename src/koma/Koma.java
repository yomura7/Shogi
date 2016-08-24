package koma;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class Koma {

	protected String[] nameList;
	protected String imgName;
	protected boolean face;
	protected boolean direction;
	protected ArrayList<Point> list = new ArrayList<Point>();

	// コンストラクタ
	public Koma(boolean direction, String[] nameList) {
		super();
		this.face = true;
		this.direction = direction;
		this.nameList = nameList;

		if (direction == true) {
			this.imgName = nameList[0];
		} else {
			this.imgName = nameList[1];
		}
	}

	// 成る
	public void naru() {
		final int KOMA_STATE_SIZE = 4;
		if (nameList.length == KOMA_STATE_SIZE) {
			this.face = !(this.face);
			if (direction == true) {
				this.imgName = nameList[2];
			} else {
				this.imgName = nameList[3];
			}
		}
	}

	// 配置可能マップの取得
	abstract public List<Point> getMoveList();

	public String getImgName() {
		return imgName;
	}

	public boolean isDirection() {
		return direction;
	}

	public boolean isFace() {
		return face;
	}

}
