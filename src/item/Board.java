package item;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;

import javax.swing.ImageIcon;

import koma.Koma;

/* MVCモデル - Model */
// 将棋盤、駒台の状態を保持するためのクラス

// 名前はGameStateとかでいいかも

public class Board  extends Observable{

	// 現在の盤面の状態を保持
	private Masu[] masu = new Masu[View.SIZE * View.SIZE];
	private Komadai komadai1;
	private Komadai komadai2;
	private Masu srcMasu = new Masu();
	private Masu dstMasu = new Masu();

	public Board(){
		for (int i = 0; i < masu.length; i++) {
			masu[i] = new Masu(i);
			masu[i].setBackground(Color.DARK_GRAY);
		}
		this.komadai1 = new Komadai();
		this.komadai2 = new Komadai();

	}

	/* 駒の配置 */
	// [例] ９一歩(左上)・・・putKoma(9, 1, Fu)
	public void putKoma(int x, int y, Koma koma) {
		ImageIcon icon = new ImageIcon(koma.getImgName());
		getMasu(new Point(x, y)).setIcon(icon);
		getMasu(new Point(x, y)).setKoma(koma);
	}

	public void changed(){
		setChanged();
		notifyObservers(masu);
		System.out.println("Board changed");
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

	public Komadai getKomadai1() {
		return komadai1;
	}
	public void setKomadai1(Komadai komadai1) {
		this.komadai1 = komadai1;
	}

	public Komadai getKomadai2() {
		return komadai2;
	}
	public void setKomadai2(Komadai komadai2) {
		this.komadai2 = komadai2;
	}

	public Masu getSrcMasu() {
		return srcMasu;
	}
	public void setSrcMasu(Masu srcKoma) {
		this.srcMasu = srcKoma;
	}

	public Masu getDstMasu() {
		return dstMasu;
	}
	public void setDstMasu(Masu dstKoma) {
		this.dstMasu = dstKoma;
	}



}
