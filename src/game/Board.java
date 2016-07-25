package game;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import koma.Koma;

// 将棋盤、駒台の状態を表示・変更するためのクラス
public class Board extends JFrame {

	static public final int SIZE = 9;
	static private boolean clickFlag = false;
	static private Masu[] masu = new Masu[SIZE * SIZE];

	// ==== Main ====
	public static void main(String[] args) {
		Board frame = new Board("Shogi");
		frame.setVisible(true);
	}

	// コンストラクタ (Boardは一度だけ生成）※Singletonパターン？
	private Board(String title) {
		this.setTitle(title);
		this.setBounds(50, 50, 500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// マスの初期化
		for (int i = 0; i < masu.length; i++) {
			masu[i] = new Masu(i);
		}

		// 駒台の追加
		Komadai komadai1 = new Komadai();
		Komadai komadai2 = new Komadai();
		getContentPane().add(komadai1.getPanel(), BorderLayout.NORTH);
		getContentPane().add(komadai2.getPanel(), BorderLayout.SOUTH);

		// メニューバーの配置
		Setting.setManuBar(this);

		// ボタンの配置
		JPanel panel = Setting.setMainField();
		getContentPane().add(panel, BorderLayout.CENTER);

		// 駒の初期配置
		Setting.initPlace();
	}

	// ==== Method ====

	/* Getter */
	static public Masu getMasu(int index){
		return masu[index];
	}
	static public Masu getMasu(Point p){
		return masu[point2index(p)];
	}

	/* 駒の配置 */
	// [例] ９一歩(左上)・・・putKoma(9, 1, Fu)
	static public void putKoma(int x, int y, Koma koma) {
		ImageIcon icon = new ImageIcon(koma.getImgName());
		masu[point2index(new Point(x, y))].setIcon(icon);
		masu[point2index(new Point(x, y))].setKoma(koma);
	}

	/* 盤座標と通し番号の変換 */
	// 盤座標→通し番号
	static public int point2index(Point p) {
		return ( (9 - p.x) + ((p.y - 1) * 9));
	}
	// 通し番号→盤座標
	static public Point index2point(int index) {
		int y = (index / 9) + 1;
		int x = 9 - (index % 9);
		return new Point(x, y);
	}

	/* フラグ管理 */
	static public boolean getClickFlag(){
		return clickFlag;
	}
	static public void invertFlag(){
		clickFlag = !clickFlag;
	}

	/* 配置判定 */
	// 駒を置けるかどうか判定
	// TODO 自分の駒か相手の駒か判定
	static public boolean isPlaceable(Point p){
		if(p.x >= 1 && p.x <= 9){
			if(p.y >= 1 && p.y <= 9){
				return true;
			}
		}
		return false;
	}

}
