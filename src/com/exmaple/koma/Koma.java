package com.exmaple.koma;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class Koma {

	protected String[] imgNameList;
	protected String[] komaNameList;
	protected String komaName;

	protected boolean face;
	protected boolean direction;
	protected ArrayList<Point> list = new ArrayList<Point>();

	// コンストラクタ
	public Koma(boolean direction, String[] imgNameList, String[] komaNameList) {
		super();
		this.face = true;
		this.direction = direction;
		this.komaNameList = komaNameList;
		this.komaName = komaNameList[0];
		this.imgNameList = imgNameList;
	}

	// TODO 今は使ってない（今の仕様では駒をとるときに成っていると持ち駒に入らなくなる）
	public void rename(int num){
		if (komaNameList.length == 2) {
			if (num == 2) {
				this.komaName = komaNameList[0];
			} else if (num ==3){
				this.komaName = komaNameList[1];
			}
		} else {
			this.komaName = komaNameList[num];
		}
	}

	// 成る
	public void naru() {
		final int KOMA_STATE_SIZE = 4;
		if (imgNameList.length == KOMA_STATE_SIZE) {
			this.face = false;
		}
	}
	public void reset() {
		face = true;
	}

	// 配置可能マップの取得
	abstract public List<Point> getMoveList(Point p);


	public boolean isDirection() {
		return direction;
	}

	public boolean turnDirection() {
		this.direction = !(this.direction);
		return direction;
	}

	public boolean isFace() {
		return face;
	}

	public String getKomaName() {
		return komaName;
	}

	public String getImgNameList(int i) {
		return imgNameList[i];
	}

}
