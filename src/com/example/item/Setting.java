package com.example.item;

import com.exmaple.koma.Fu;
import com.exmaple.koma.Gin;
import com.exmaple.koma.Gyoku;
import com.exmaple.koma.Hisha;
import com.exmaple.koma.Kaku;
import com.exmaple.koma.Keima;
import com.exmaple.koma.Kin;
import com.exmaple.koma.Koma;
import com.exmaple.koma.Kyosha;

// 初期設定クラス
public class Setting {

	static public final int HIRATE = 0;
	private int handicap;

	public Setting(int _handicap) {
		handicap = _handicap;
	}

	// 平手の初期配置にセット

	// TODO 最後に stateをｂに入れる

	public void initPlace(Board shogiBoard) {

		if (handicap == HIRATE) {

			// 歩の配置
			Koma fu11 = new Fu(true);
			Koma fu12 = new Fu(true);
			Koma fu13 = new Fu(true);
			Koma fu14 = new Fu(true);
			Koma fu15 = new Fu(true);
			Koma fu16 = new Fu(true);
			Koma fu17 = new Fu(true);
			Koma fu18 = new Fu(true);
			Koma fu19 = new Fu(true);
			Koma fu21 = new Fu(false);
			Koma fu22 = new Fu(false);
			Koma fu23 = new Fu(false);
			Koma fu24 = new Fu(false);
			Koma fu25 = new Fu(false);
			Koma fu26 = new Fu(false);
			Koma fu27 = new Fu(false);
			Koma fu28 = new Fu(false);
			Koma fu29 = new Fu(false);

			shogiBoard.putKoma(1, 7, fu11);
			shogiBoard.putKoma(2, 7, fu12);
			shogiBoard.putKoma(3, 7, fu13);
			shogiBoard.putKoma(4, 7, fu14);
			shogiBoard.putKoma(5, 7, fu15);
			shogiBoard.putKoma(6, 7, fu16);
			shogiBoard.putKoma(7, 7, fu17);
			shogiBoard.putKoma(8, 7, fu18);
			shogiBoard.putKoma(9, 7, fu19);
			shogiBoard.putKoma(1, 3, fu21);
			shogiBoard.putKoma(2, 3, fu22);
			shogiBoard.putKoma(3, 3, fu23);
			shogiBoard.putKoma(4, 3, fu24);
			shogiBoard.putKoma(5, 3, fu25);
			shogiBoard.putKoma(6, 3, fu26);
			shogiBoard.putKoma(7, 3, fu27);
			shogiBoard.putKoma(8, 3, fu28);
			shogiBoard.putKoma(9, 3, fu29);

			// 香の配置
			Koma kyo11 = new Kyosha(true);
			Koma kyo12 = new Kyosha(true);
			Koma kyo21 = new Kyosha(false);
			Koma kyo22 = new Kyosha(false);
			shogiBoard.putKoma(1, 9, kyo11);
			shogiBoard.putKoma(9, 9, kyo12);
			shogiBoard.putKoma(1, 1, kyo21);
			shogiBoard.putKoma(9, 1, kyo22);

			// 桂の配置
			Koma kei11 = new Keima(true);
			Koma kei12 = new Keima(true);
			Koma kei21 = new Keima(false);
			Koma kei22 = new Keima(false);
			shogiBoard.putKoma(2, 9, kei11);
			shogiBoard.putKoma(8, 9, kei12);
			shogiBoard.putKoma(2, 1, kei21);
			shogiBoard.putKoma(8, 1, kei22);

			// 銀の配置
			Koma gin11 = new Gin(true);
			Koma gin12 = new Gin(true);
			Koma gin21 = new Gin(false);
			Koma gin22 = new Gin(false);
			shogiBoard.putKoma(3, 9, gin11);
			shogiBoard.putKoma(7, 9, gin12);
			shogiBoard.putKoma(3, 1, gin21);
			shogiBoard.putKoma(7, 1, gin22);

			// 金の配置
			Koma kin11 = new Kin(true);
			Koma kin12 = new Kin(true);
			Koma kin21 = new Kin(false);
			Koma kin22 = new Kin(false);
			shogiBoard.putKoma(4, 9, kin11);
			shogiBoard.putKoma(6, 9, kin12);
			shogiBoard.putKoma(4, 1, kin21);
			shogiBoard.putKoma(6, 1, kin22);

			// 飛の配置
			Koma hisha1 = new Hisha(true);
			Koma hisha2 = new Hisha(false);
			shogiBoard.putKoma(2, 8, hisha1);
			shogiBoard.putKoma(8, 2, hisha2);

			// 角の配置
			Koma kaku1 = new Kaku(true);
			Koma kaku2 = new Kaku(false);
			shogiBoard.putKoma(8, 8, kaku1);
			shogiBoard.putKoma(2, 2, kaku2);

			// 玉の配置
			Koma gyoku1 = new Gyoku(true);
			Koma gyoku2 = new Gyoku(false);
			shogiBoard.putKoma(5, 9, gyoku1);
			shogiBoard.putKoma(5, 1, gyoku2);
		}

	}

}
