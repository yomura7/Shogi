package item;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import koma.Koma;

/* MVCモデル - Controller */
//マウスイベント時の処理を定義するクラス

public class Controller  implements Observer {

	private Board shogiBoard = new Board();
	private View UI = new View();

	// ==== Main ====
	public static void main(String[] args) {

		Board shogiBoard = new Board();

		// UIの生成
		UI.setVisible(true);

		// 駒の初期配置
		Setting setting = new Setting(Setting.HIRATE);
		setting.initPlace(shogiBoard);	// TODO 未完成

	}

	// 将棋盤のセット
	private JPanel setMainField() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		GridLayout layout = new GridLayout(View.SIZE, View.SIZE);
		layout.setHgap(5);
		layout.setVgap(5);
		panel.setLayout(layout);

		for (int i = 0; i < View.SIZE*View.SIZE; i++) {
			KomaListener KL = new KomaListener();
			Masu m = shogiBoard.getState().getMasu(i);

			m.setBackground(Color.DARK_GRAY);
			m.addMouseListener(KL);
			KL.addObserver(this);
			panel.add(m);
		}
		return panel;
	}

	// クリック時のマスを受け取っていろいろ処理
	public void update(Observable o, Object arg){
		// 引数を受け取る
		Masu m = new Masu();
		m = (Masu)arg;

		// 色々な処理

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
			View.moveKoma(GameMaster.getPrevMasu(), m);
			GameMaster.deleteMap();
			GameMaster.invertFlag();
			Draw.coloringMap();
		}

		// 駒の更新
		for (int i = 0; i < View.SIZE*View.SIZE; i++) {

			state.getMasu(i).setBackground(Color.DARK_GRAY);
		}

		// 駒台の更新
		for (int i = 0; i < 2*View.SIZE; i++) {
			state.getKomadai1().setBackground(Color.DARK_GRAY);
		}
	}

	/* 駒の配置 */
	// [例] ９一歩(左上)・・・putKoma(9, 1, Fu)
	public void putKoma(int x, int y, Koma koma) {
		ImageIcon icon = new ImageIcon(koma.getImgName());
		State state = View.state;
		state.getMasu(new Point(x, y)).setIcon(icon);
		state.getMasu(new Point(x, y)).setKoma(koma);
	}

	public void moveKoma(Masu m_before, Masu m_after) {

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


}
