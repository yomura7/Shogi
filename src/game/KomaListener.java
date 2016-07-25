package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


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
//		System.out.println(m.getKoma().getImgName());
//		System.out.println("index = " + index);
//		System.out.println(point);

		// クリックした駒の配置可能マップインスタンスを生成
		PlaceableMap pmap = new PlaceableMap(m);
		pmap.createMap(m);

		// クリック1度目・・・配置可能位置を着色
		// クリック2度目・・・着色をリセット
		if (Board.getClickFlag() == false) {
			Draw.coloringPlaceableMap(pmap);
		} else {
			Draw.clearPlaceableMap();
		}

		Board.invertFlag();
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
