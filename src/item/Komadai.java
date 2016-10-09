package item;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;

import koma.Koma;

// 駒台（取った駒を置くための台）
public class Komadai {

	public static final int KOMADAI_SIZE = 7;

	private Masu[] mochigoma = new Masu[2 * KOMADAI_SIZE];
	// "歩", "香", "桂", "銀", "金", "角", "飛"

	private int[] komaNum = new int[KOMADAI_SIZE];
	private JPanel panel = new JPanel();

	public Komadai(int side) {
		super();
		// ラベルの初期化
		for (int i = 0; i < mochigoma.length; i++) {
			mochigoma[i] = new Masu();
			mochigoma[i].setName(String.valueOf(i+side*10));
		}

		// パネルの配置
		panel.setBackground(Color.BLACK);
		GridLayout layout = new GridLayout(2, KOMADAI_SIZE);
		layout.setHgap(5);
		layout.setVgap(5);
		panel.setLayout(layout);

		for (int i = 0; i < mochigoma.length; i++) {
			mochigoma[i].setBackground(Color.LIGHT_GRAY);
			mochigoma[i].setOpaque(true);
			mochigoma[i].setText("　");
			mochigoma[i].setFont(new Font("メイリオ", Font.BOLD, 16));
			panel.add(mochigoma[i]);
		}


	}

	public JPanel getPanel(){
		return panel;
	}

	public void addKoma(Koma koma){
//		koma.reset();
		int i=0;
		String nameArr[] = {"歩", "香", "桂", "銀", "金", "角", "飛"};
		for (String name: nameArr){
			if (koma.getKomaName() == name) {
				komaNum[i]++;
			}
			i++;
		}
	}

	public void removeMochigoma(int index){
		komaNum[index]--;
	}

	public Masu getMochigoma(int index) {
		return mochigoma[index];
	}

	public int getKomaNum(int index) {
		return komaNum[index];
	}

}
