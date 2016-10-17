package com.example.item;

import java.awt.Point;
import java.util.Observable;

import com.exmaple.koma.Koma;

/* MVCモデル - Model */
// 将棋盤、駒台の状態を保持するためのクラス

public class Board  extends Observable{

	// 現在の盤面の状態を保持
	static public final int SIZE = 9;

	private Masu[] masu = new Masu[SIZE * SIZE];
	private Komadai[] komadai = new Komadai[2];
	private Masu srcMasu;
	private int komadaiNum;
	private Masu latestMasu;

	public Board(){
		for (int i = 0; i < masu.length; i++) {
			masu[i] = new Masu(i);
		}
		komadai[0] = new Komadai(0);
		komadai[1] = new Komadai(1);
		komadaiNum = -1;
	}

	/* 駒の配置 */
	// [例] ９一歩(左上)・・・putKoma(9, 1, Fu)
	public void putKoma(int x, int y, Koma koma) {
		getMasu(new Point(x, y)).setKoma(koma);
	}
	// 駒の削除
	public void removeKoma(int x, int y) {
		int index = ((9 - x) + ((y - 1) * 9));
		masu[index].setKoma(null);
	}


	/* Getter */
	public Masu getMasu(int index) {
		return masu[index];
	}
	public Masu getMasu(Point p) {
		if (p.x < 1 || p.x > 9) return null;
		if (p.y < 1 || p.y > 9) return null;
		int index = ((9 - p.x) + ((p.y - 1) * 9));
		return masu[index];
	}

	public void putKomadai(boolean turn, Koma koma) {
		if (turn == true) {
			komadai[0].addKoma(koma);
		} else {
			komadai[1].addKoma(koma);
		}
	}

	public Komadai getKomadai(int num) {
		return komadai[num];
	}

	public Masu getSrcMasu() {
		return srcMasu;
	}
	public void setSrcMasu(Masu srcKoma) {
		this.srcMasu = srcKoma;
	}



	public int getKomadaiNum() {
		return komadaiNum;
	}

	public void setKomadaiNum(int komadaiNum) {
		this.komadaiNum = komadaiNum;
	}

	public Masu getLatestMasu() {
		return latestMasu;
	}

	public void setLatestMasu(Masu latestMasu) {
		this.latestMasu = latestMasu;
	}



}
