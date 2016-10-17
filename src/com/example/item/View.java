package com.example.item;

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
		String nameArr[] = {"歩", "香", "桂", "銀", "金", "角", "飛"};
		for (int i = 0; i < Komadai.KOMADAI_SIZE; i++) {
			int[] num = new int[2];
			for (int j=0; j<2; j++) {
				num[j]= nowBoard.getKomadai(j).getKomaNum(i);
				if (num[j] >= 1) {
					nowBoard.getKomadai(j).getMochigoma(Komadai.KOMADAI_SIZE+i).setText(String.valueOf(num[j]));
					nowBoard.getKomadai(j).getMochigoma(i).setText(nameArr[i]);
				} else {
					nowBoard.getKomadai(j).getMochigoma(Komadai.KOMADAI_SIZE+i).setText(null);
					nowBoard.getKomadai(j).getMochigoma(i).setText(null);
				}
			}
		}
	}

	private void initView() {
		// ウィンドウの設定
		this.setTitle("Shogi");
		this.setSize(500, 650);
		this.setLocationRelativeTo(null);
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
		JPanel panelA = new JPanel();
		panelA.setBackground(Color.BLACK);
		// レイアウト設定
		GridLayout layoutA = new GridLayout(Board.SIZE, Board.SIZE);
		layoutA.setHgap(5);
		layoutA.setVgap(5);
		panelA.setLayout(layoutA);
		// マスのセット
		for (int i = 0; i < Board.SIZE * Board.SIZE; i++) {
			Masu m = shogiBoard.getMasu(i);
			panelA.add(m);
		}
		this.add(panelA, BorderLayout.CENTER);
		getContentPane().add(shogiBoard.getKomadai(0).getPanel(), BorderLayout.NORTH);
		getContentPane().add(shogiBoard.getKomadai(1).getPanel(), BorderLayout.SOUTH);

/*
		// パネルの配置
		GridLayout layoutB = new GridLayout(2, Komadai.KOMADAI_SIZE);
		layoutB.setHgap(5);
		layoutB.setVgap(5);
		JPanel[] panelB = new JPanel[2];
		for (int j=0; j>2; j++) {
//			panelB[j].setBackground(Color.BLACK);
			panelB[j].setLayout(layoutB);
			for (int i = 0; i < 2*Komadai.KOMADAI_SIZE; i++) {
				shogiBoard.getKomadai(j).getMochigoma(i).setBackground(Color.LIGHT_GRAY);
				shogiBoard.getKomadai(j).getMochigoma(i).setOpaque(true);
				shogiBoard.getKomadai(j).getMochigoma(i).setText("＠");
				shogiBoard.getKomadai(j).getMochigoma(i).setFont(new Font("メイリオ", Font.BOLD, 16));
				panelB[j].add(shogiBoard.getKomadai(j).getMochigoma(i));
			}
			if (j==0){
//				panelA.add(panelB[j], BorderLayout.NORTH);
				this.add(panelB[j], BorderLayout.NORTH);
//				getContentPane().add(panelB[j], BorderLayout.CENTER);
			} else {
				this.add(panelB[j], BorderLayout.SOUTH);
//				panelA.add(panelB[j], BorderLayout.SOUTH);
//				getContentPane().add(panelB[j], BorderLayout.SOUTH);
			}
		}
//		contentPane.add(panelB[0]);
//		contentPane.add(panelB[1]);
*/

	}
}
