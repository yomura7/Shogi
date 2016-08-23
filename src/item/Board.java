package item;

import java.util.Observable;

/* MVCモデル - Model */
// 将棋盤、駒台の状態を保持するためのクラス

// 名前はGameStateとかでいいかも

public class Board  extends Observable{

	// 現在の盤面の状態を保持
	private State state;
	private Komadai komadai1 = new Komadai();
	private Komadai komadai2 = new Komadai();

	public Board(){

	}

	public State getState() {
		return state;
	}

	public void setState(State _state) {
		state = _state;
		setChanged();
		notifyObservers(state);
		System.out.println("state changed");
	}

	public Komadai getKomadai1() {
		return komadai1;
	}

	public void setKomadai1(Komadai komadai1) {
		this.komadai1 = komadai1;
	}

	public Komadai getKomadai2() {
		return komadai2;
	}

	public void setKomadai2(Komadai komadai2) {
		this.komadai2 = komadai2;
	}


}
