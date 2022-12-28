package game;

import javafx.scene.Node;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

import game.Unit;
import game.Player;

public class Position extends Monad
{
	public Player[] players = null;
	public Unit ruler = null;
	
	public Position(Player[] players, Unit ruler, Node icon, String name, double value) {
		super(icon, name, value);
		setPlayers(players);
		this.ruler = ruler;
		// TODO Auto-generated constructor stub
	}
	
	public void setPlayers(Player[] players) 
	{
		// TODO Auto-generated method stub
		this.players = players;
	}
	
}
