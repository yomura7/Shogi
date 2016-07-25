package game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import koma.Fu;
import koma.Gin;
import koma.Gyoku;
import koma.Hisha;
import koma.Kaku;
import koma.Keima;
import koma.Kin;
import koma.Koma;
import koma.Kyosha;

// 初期設定クラス
public class Setting {

	private static final int SIZE = Board.SIZE;

	// メニューバーのセット
	static public void setManuBar(Board b) {
		JMenuBar mbar = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Edit");
		mbar.add(menu1);
		mbar.add(menu2);
		JMenuItem menuitem1 = new JMenuItem("New");
		JMenuItem menuitem2 = new JMenuItem("Open");
		JMenuItem menuitem3 = new JMenuItem("Close");
		menu1.add(menuitem1);
		menu1.add(menuitem2);
		menu1.add(menuitem3);
		b.setJMenuBar(mbar);
	}

	// 将棋盤のセット
	static public JPanel setMainField() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		GridLayout layout = new GridLayout(SIZE, SIZE);
		layout.setHgap(5);
		layout.setVgap(5);
		panel.setLayout(layout);

		for (int i = 0; i < 81; i++) {
			Board.getMasu(i).setBackground(Color.DARK_GRAY);
			Board.getMasu(i).addMouseListener(new KomaListener());
			panel.add(Board.getMasu(i));
		}
		return panel;
	}

	// 平手の初期配置にセット
	static public void initPlace() {
		// 歩の配置
		Koma fu1 = new Fu(true, true);
		Koma fu2 = new Fu(true, false);
		for (int i = 0; i < 9; i++) {
			Board.putKoma(i + 1, 7, fu1);
			Board.putKoma(i + 1, 3, fu2);
		}

		// 香の配置
		Koma kyo1 = new Kyosha(true, true);
		Koma kyo2 = new Kyosha(true, false);
		Board.putKoma(1, 9, kyo1);
		Board.putKoma(9, 9, kyo1);
		Board.putKoma(1, 1, kyo2);
		Board.putKoma(9, 1, kyo2);

		// 桂の配置
		Koma kei1 = new Keima(true, true);
		Koma kei2 = new Keima(true, false);
		Board.putKoma(2, 9, kei1);
		Board.putKoma(8, 9, kei1);
		Board.putKoma(2, 1, kei2);
		Board.putKoma(8, 1, kei2);

		// 銀の配置
		Koma gin1 = new Gin(true, true);
		Koma gin2 = new Gin(true, false);
		Board.putKoma(3, 9, gin1);
		Board.putKoma(7, 9, gin1);
		Board.putKoma(3, 1, gin2);
		Board.putKoma(7, 1, gin2);

		// 金の配置
		Koma kin1 = new Kin(true, true);
		Koma kin2 = new Kin(true, false);
		Board.putKoma(4, 9, kin1);
		Board.putKoma(6, 9, kin1);
		Board.putKoma(4, 1, kin2);
		Board.putKoma(6, 1, kin2);

		// 飛の配置
		Koma hisha1 = new Hisha(true, true);
		Koma hisha2 = new Hisha(true, false);
		Board.putKoma(2, 8, hisha1);
		Board.putKoma(8, 2, hisha2);

		// 角の配置
		Koma kaku1 = new Kaku(true, true);
		Koma kaku2 = new Kaku(true, false);
		Board.putKoma(8, 8, kaku1);
		Board.putKoma(2, 2, kaku2);

		// 玉の配置
		Koma gyoku1 = new Gyoku(true, true);
		Koma gyoku2 = new Gyoku(true, false);
		Board.putKoma(5, 9, gyoku1);
		Board.putKoma(5, 1, gyoku2);
	}


}
