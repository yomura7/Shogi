package com.example.item;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;


public class KomaListener  extends Observable implements MouseListener {

	public KomaListener() {
		super();
	}

	// 実装なし
	@Override
	public void mousePressed(MouseEvent e) {

		// クリックした座標のマスを取得
		Masu m = (Masu)e.getSource();
		setChanged();
		notifyObservers(m);
		System.out.println("clicked");
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
}
