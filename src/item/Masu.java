package item;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

import koma.Koma;

public class Masu extends JButton{

	private int index;
	private Point point;
	private Koma koma;
	private boolean komaState;
	private boolean placeable;

	public Masu() {
		super();
	}

	public Masu(int index) {
		super();
		this.index = index;
		int y = (index / 9) + 1;
		int x = 9 - (index % 9);
		this.point = new Point(x, y);
		this.komaState = false;
		this.placeable = false;
	}

	// 駒の削除
	public void removeKoma() {
		this.setIcon(null);
		this.koma = null;
		this.komaState = false;
	}

	public boolean isExistKoma(){
		return komaState;
	}

	public void setPlaceable(boolean placeable){
		this.placeable = placeable;
	}

	public boolean getPlaceable(){
		return placeable;
	}

	/* Setter/Getter */
	public void setColor(Color c){
		this.setBackground(c);
	}
	public void setKoma(Koma koma){
		this.komaState = true;
		this.koma = koma;
	}
	public int getIndex(){
		return index;
	}
	public Koma getKoma(){
		return koma;
	}
	public Point getPoint(){
		return point;
	}


}
