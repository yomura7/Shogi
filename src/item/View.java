package item;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* MVCモデル - View */
// 将棋盤、駒台の状態を表示・変更するためのクラス

public class View extends JFrame {

	static public final int SIZE = 9;

	// コンストラクタ (Singleton)
	public View() {

		// UIの初期設定
		initView();
		System.out.println("＝＝対局開始＝＝");
		System.out.println("△先手番です");

	}

	// ==== Method ====

	/* 盤の着色 */
	public void coloringMap(Board nowBoard) {
		// 移動可能位置の着色
		for (int i = 0; i < (View.SIZE * View.SIZE); i++) {
			Masu masu = nowBoard.getMasu(i);
			if (masu.getPlaceable() == true) {
				masu.setColor(Color.ORANGE);
			}else{
				masu.setColor(Color.DARK_GRAY);
			}
		}
		// 指定駒の着色
		nowBoard.getSrcMasu().setColor(Color.CYAN);
	}


	private void initView() {
		// ウィンドウの設定
		this.setTitle("Shogi");
		this.setBounds(50, 50, 500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// メニューバー
		JMenuBar mbar = new JMenuBar();
		//メイン メニュー項目
		JMenu[] menu = {
			new JMenu("File"),
			new JMenu("Edit")
		};
		mbar.add(menu[0]);
		mbar.add(menu[1]);
		// サブメニュー項目
		JMenuItem menuitem[] = {
			new JMenuItem("New"),
			new JMenuItem("Open"),
			new JMenuItem("Close")
		};
		menu[0].add(menuitem[0]);
		menu[0].add(menuitem[1]);
		menu[0].add(menuitem[2]);
		// Boardにセット
		this.setJMenuBar(mbar);
	}

	// 将棋盤のセット
	public void setMainField(Board shogiBoard) {

		// メインパネル
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);

		// レイアウト設定
		GridLayout layout = new GridLayout(View.SIZE, View.SIZE);
		layout.setHgap(5);
		layout.setVgap(5);
		panel.setLayout(layout);

		// マスのセット
		for (int i = 0; i < View.SIZE*View.SIZE; i++) {
			Masu m = shogiBoard.getMasu(i);
			panel.add(m);
		}
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(shogiBoard.getKomadai1().getPanel(), BorderLayout.NORTH);
		getContentPane().add(shogiBoard.getKomadai2().getPanel(), BorderLayout.SOUTH);

	}



}
