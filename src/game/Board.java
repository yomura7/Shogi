package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import koma.Koma;

// 将棋盤、駒台の状態を表示・変更するためのクラス
public class Board extends JFrame implements Observer, MouseListener {

	static public final int SIZE = 9;
	static private Masu[] masu = new Masu[SIZE * SIZE];
	State state = new State();

	// ==== Main ====
	public static void main(String[] args) {
		Board frame = new Board("Shogi");
		frame.setVisible(true);
		System.out.println("＝＝対局開始＝＝");
		System.out.println("△先手番です");
	}

	// コンストラクタ (Boardは一度だけ生成）※Singletonパターン？
	public Board(String title) {
		this.setTitle(title);
		this.setBounds(50, 50, 500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		state.addObserver(this);

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
		// TODO staticを使わない
		JPanel panel = setMainField();
		getContentPane().add(panel, BorderLayout.CENTER);

		// 駒の初期配置
		// TODO staticを使わない
		Setting.initPlace();
	}

	// ==== Method ====
	// TODO staticを使わない

	public void update(Observable o, Object arg){
		repaint();
		System.out.println("受信");
	}

	/* Getter */
	static public Masu getMasu(int index) {
		return masu[index];
	}

	static public Masu getMasu(Point p) {
		if (p.x < 1 || p.x > 9) return null;
		if (p.y < 1 || p.y > 9) return null;
		return masu[point2index(p)];
	}

	/* 駒の配置 */
	// [例] ９一歩(左上)・・・putKoma(9, 1, Fu)
	static public void putKoma(int x, int y, Koma koma) {
		ImageIcon icon = new ImageIcon(koma.getImgName());
		masu[point2index(new Point(x, y))].setIcon(icon);
		masu[point2index(new Point(x, y))].setKoma(koma);
	}

	static public void moveKoma(Masu m_before, Masu m_after) {

		if (m_after.getPlaceable() == true) {

			// 移動先に駒がある場合
			if (m_after.isExistKoma() == true) {
					System.out.println("駒を取りました");
			}

			// 移動先に配置
			putKoma(m_after.getPoint().x, m_after.getPoint().y,
					m_before.getKoma());
			System.out.println("Koma = " + m_before.getKoma());
			// 移動元を削除
			m_before.removeKoma();


			GameMaster.checkNaru(m_after);
			GameMaster.changeTurn();
			GameMaster.message();

		}
	}

	// 将棋盤のセット
	private JPanel setMainField() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		GridLayout layout = new GridLayout(Board.SIZE, Board.SIZE);
		layout.setHgap(5);
		layout.setVgap(5);
		panel.setLayout(layout);

		for (int i = 0; i < Board.SIZE*Board.SIZE; i++) {
			getMasu(i).setBackground(Color.DARK_GRAY);
			getMasu(i).addMouseListener(this);
			panel.add(Board.getMasu(i));
		}
		return panel;
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

	// 実装なし
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		// クリックした座標のマスを取得
		Masu m = (Masu) e.getSource();
		Koma k = m.getKoma();

		// クリック1度目・・・配置可能位置を着色
		if (GameMaster.getClickFlag() == false) {
			// 駒が存在 && 選択した駒とターンが一致
			if (m.isExistKoma() == true &&
					GameMaster.getTurn() == k.isDirection()) {
				// クリックした駒の配置可能マップインスタンスを生成
				ArrayList<Point>pList = m.getKoma().getMoveList(m.getPoint());

				GameMaster.createMap(pList);
				pList.clear();
				GameMaster.setPrevMasu(m);
				GameMaster.invertFlag();
				Draw.coloringMap();
			}
		// クリック2度目・・・着色をリセット
		} else {
			Board.moveKoma(GameMaster.getPrevMasu(), m);
			GameMaster.deleteMap();
			GameMaster.invertFlag();
			Draw.coloringMap();

			// 被観測者を更新→updateが発生
			state.change();

		}

	}

	// 実装なし
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

}
