package game;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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


	// 平手の初期配置にセット
	static public void initPlace() {
		// 歩の配置
		Koma fu1 = new Fu(true);
		Koma fu2 = new Fu(false);
		for (int i = 0; i < Board.SIZE; i++) {
			Board.putKoma(i + 1, 7, fu1);
			Board.putKoma(i + 1, 3, fu2);
		}

		// 香の配置
		Koma kyo1 = new Kyosha(true);
		Koma kyo2 = new Kyosha(false);
		Board.putKoma(1, 9, kyo1);
		Board.putKoma(9, 9, kyo1);
		Board.putKoma(1, 1, kyo2);
		Board.putKoma(9, 1, kyo2);

		// 桂の配置
		Koma kei1 = new Keima(true);
		Koma kei2 = new Keima(false);
		Board.putKoma(2, 9, kei1);
		Board.putKoma(8, 9, kei1);
		Board.putKoma(2, 1, kei2);
		Board.putKoma(8, 1, kei2);

		// 銀の配置
		Koma gin1 = new Gin(true);
		Koma gin2 = new Gin(false);
		Board.putKoma(3, 9, gin1);
		Board.putKoma(7, 9, gin1);
		Board.putKoma(3, 1, gin2);
		Board.putKoma(7, 1, gin2);

		// 金の配置
		Koma kin1 = new Kin(true);
		Koma kin2 = new Kin(false);
		Board.putKoma(4, 9, kin1);
		Board.putKoma(6, 9, kin1);
		Board.putKoma(4, 1, kin2);
		Board.putKoma(6, 1, kin2);

		// 飛の配置
		Koma hisha1 = new Hisha(true);
		Koma hisha2 = new Hisha(false);
		Board.putKoma(2, 8, hisha1);
		Board.putKoma(8, 2, hisha2);

		// 角の配置
		Koma kaku1 = new Kaku(true);
		Koma kaku2 = new Kaku(false);
		Board.putKoma(8, 8, kaku1);
		Board.putKoma(2, 2, kaku2);

		// 玉の配置
		Koma gyoku1 = new Gyoku(true);
		Koma gyoku2 = new Gyoku(false);
		Board.putKoma(5, 9, gyoku1);
		Board.putKoma(5, 1, gyoku2);
	}


}
