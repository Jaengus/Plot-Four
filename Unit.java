package boardgame;

import game.Monad;
import javafx.scene.Node;

public abstract class Unit extends Monad {
	public Unit(Node icon, String name, double value) {
		super(icon, name, value);
		// TODO Auto-generated constructor stub
	}

	public abstract boolean move(Position[][] grid, Position pos);
}
