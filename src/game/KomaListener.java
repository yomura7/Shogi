package game;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

// マウスイベント時の処理を定義するクラス
public class KomaListener implements MouseListener {

	public KomaListener() {
		super();
	}

	// ボタンをクリックしたときの動作
	@Override
	public void mouseClicked(MouseEvent e) {

		// クリックした座標のマスを取得
		Masu m = (Masu) e.getSource();

		// クリック1度目・・・配置可能位置を着色
		// クリック2度目・・・着色をリセット
		if (GameMaster.getClickFlag() == false) {

			if (m.isExistKoma() == true) {
				// クリックした駒の配置可能マップインスタンスを生成
				ArrayList<Point>pList = m.getKoma().getMoveList(m.getPoint());
				GameMaster.createMap(pList);
				pList.clear();
				GameMaster.setPrevMasu(m);
				GameMaster.invertFlag();
				Draw.coloringMap();
			}

		} else {

			Board.moveKoma(GameMaster.getPrevMasu(), m);
			GameMaster.deleteMap();
			GameMaster.invertFlag();
			Draw.coloringMap();
		}

	}

	// 実装なし
	@Override
	public void mousePressed(MouseEvent e) {
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
