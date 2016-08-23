package item;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* MVCモデル - View */
// 将棋盤、駒台の状態を表示・変更するためのクラス

public class View extends JFrame implements Observer {

	static public final int SIZE = 9;

	// コンストラクタ (Singleton)
	public View() {

		// UIの初期設定
		initView();
		System.out.println("＝＝対局開始＝＝");
		System.out.println("△先手番です");

	}

	// ==== Method ====
	public void update(Observable o, Object arg){
		// 引数を受け取る
		shogiBoard = (Board)arg;

		// 描画処理いろいろ




		repaint();
		System.out.println("盤面を更新しました");
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

		JPanel panel = setMainField();
		getContentPane().add(panel, BorderLayout.CENTER);

		getContentPane().add(shogiBoard.getKomadai1().getPanel(), BorderLayout.NORTH);
		getContentPane().add(shogiBoard.getKomadai2().getPanel(), BorderLayout.SOUTH);

	}

}
