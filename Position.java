package boardgame;

import javafx.scene.Node;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import game.Monad;

public class Position extends Monad
{
	public Monad ruler;
	public Position(Node icon, String name, double value) {
		super(icon, name, value);
		// TODO Auto-generated constructor stub
	}
}
