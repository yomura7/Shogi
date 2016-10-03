package item;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* MVCモデル - View */
// 将棋盤、駒台の状態を表示・変更するためのクラス

public class View extends JFrame implements Observer{

	// コンストラクタ (Singleton)
	public View() {
		// UIの初期設定
		initView();
		System.out.println("＝＝対局開始＝＝");
	}

	// ==== Method ====
	@Override
	public void update(Observable o, Object arg) {

		Board nowBoard = (Board)arg;

		// 盤面の更新
		for (int i = 0; i < (Board.SIZE * Board.SIZE); i++) {
			Masu masu = nowBoard.getMasu(i);

			if (masu.getKoma() == null) {
				masu.setIcon(null);
				continue;
			}

			boolean direction = masu.getKoma().isDirection();
			boolean face = masu.getKoma().isFace();

			ImageIcon icon;
			if (direction == true && face == true) {
				icon = new ImageIcon(masu.getKoma().getImgNameList(0));
//				masu.getKoma().rename(0);
			} else if (direction == false && face == true) {
				icon = new ImageIcon(masu.getKoma().getImgNameList(1));
//				masu.getKoma().rename(1);
			} else if (direction == true && face == false) {
				icon = new ImageIcon(masu.getKoma().getImgNameList(2));
//				masu.getKoma().rename(2);
			} else if (direction == false && face == false) {
				icon = new ImageIcon(masu.getKoma().getImgNameList(3));
//				masu.getKoma().rename(3);
			} else {
				icon = null;
			}
			masu.setIcon(icon);
		}


		// 移動可能位置の着色
		for (int i = 0; i < (Board.SIZE * Board.SIZE); i++) {
			Masu masu = nowBoard.getMasu(i);
			if (masu.getPlaceable() == true) {
				masu.setColor(Color.ORANGE);
			}else{
				masu.setColor(Color.DARK_GRAY);
			}
		}
		if (nowBoard.getSrcMasu() != null) {
			// 指定駒の着色
			nowBoard.getSrcMasu().setColor(Color.CYAN);
		}
		// 直前駒の着色
		if (nowBoard.getLatestMasu() != null) {
			nowBoard.getLatestMasu().setColor(Color.GREEN);
		}

		// 駒台更新
		for (int i = 0; i < Komadai.KOMADAI_SIZE; i++) {
			int num;
			num= nowBoard.getKomadai(0).getKomaNum(i);
			nowBoard.getKomadai(0).getMochigoma(Komadai.KOMADAI_SIZE+i).setText(String.valueOf(num));

			num = nowBoard.getKomadai(1).getKomaNum(i);
			nowBoard.getKomadai(1).getMochigoma(Komadai.KOMADAI_SIZE+i).setText(String.valueOf(num));
		}



	}




	private void initView() {
		// ウィンドウの設定
		this.setTitle("Shogi");
		this.setBounds(50, 50, 500, 650);
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
		GridLayout layout = new GridLayout(Board.SIZE, Board.SIZE);
		layout.setHgap(5);
		layout.setVgap(5);
		panel.setLayout(layout);

		// マスのセット
		for (int i = 0; i < Board.SIZE * Board.SIZE; i++) {
			Masu m = shogiBoard.getMasu(i);
			panel.add(m);
		}
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(shogiBoard.getKomadai(0).getPanel(), BorderLayout.SOUTH);
		getContentPane().add(shogiBoard.getKomadai(1).getPanel(), BorderLayout.NORTH);

	}



}
