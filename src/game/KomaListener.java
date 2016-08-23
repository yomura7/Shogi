package game;

import java.util.Observable;


// マウスイベント時の処理を定義するクラス
public class KomaListener  extends Observable /* implements MouseListener*/ {

	public KomaListener() {
		super();
	}
/*
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
*/
}
