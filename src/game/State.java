package game;

import java.util.Observable;

public class State extends Observable{

	private static int x;

	public State() {
		x = 0;
	}

	public void change() {
		System.out.println("通知"+x);
		x++;
		setChanged();
		notifyObservers(x);
	}
}
