package game;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

import koma.Koma;

public class Masu extends JButton{

	private int index;
	private Point point;
	private Koma koma;

	public Masu() {
		super();
	}

	public Masu(int index) {
		super();
		this.index = index;
		this.point = Board.index2point(index);
	}

	public void setColor(Color c){
		this.setBackground(c);
	}
	public void setKoma(Koma koma){
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
