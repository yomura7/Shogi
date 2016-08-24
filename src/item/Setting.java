package item;

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
			Koma fu1 = new Fu(true);
			Koma fu2 = new Fu(false);
			for (int i = 0; i < View.SIZE; i++) {
				shogiBoard.putKoma(i + 1, 7, fu1);
				shogiBoard.putKoma(i + 1, 3, fu2);
			}

			// 香の配置
			Koma kyo1 = new Kyosha(true);
			Koma kyo2 = new Kyosha(false);
			shogiBoard.putKoma(1, 9, kyo1);
			shogiBoard.putKoma(9, 9, kyo1);
			shogiBoard.putKoma(1, 1, kyo2);
			shogiBoard.putKoma(9, 1, kyo2);

			// 桂の配置
			Koma kei1 = new Keima(true);
			Koma kei2 = new Keima(false);
			shogiBoard.putKoma(2, 9, kei1);
			shogiBoard.putKoma(8, 9, kei1);
			shogiBoard.putKoma(2, 1, kei2);
			shogiBoard.putKoma(8, 1, kei2);

			// 銀の配置
			Koma gin1 = new Gin(true);
			Koma gin2 = new Gin(false);
			shogiBoard.putKoma(3, 9, gin1);
			shogiBoard.putKoma(7, 9, gin1);
			shogiBoard.putKoma(3, 1, gin2);
			shogiBoard.putKoma(7, 1, gin2);

			// 金の配置
			Koma kin1 = new Kin(true);
			Koma kin2 = new Kin(false);
			shogiBoard.putKoma(4, 9, kin1);
			shogiBoard.putKoma(6, 9, kin1);
			shogiBoard.putKoma(4, 1, kin2);
			shogiBoard.putKoma(6, 1, kin2);

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
