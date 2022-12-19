package plot_four;

import javafx.scene.Node;
import game.Player;
import game.Position;
import game.Position_Manager;
import game.Unit;

public class Disc extends Unit
{
	public Disc(Player player, Node icon, String name, double value, Position position) 
	{
		super(player, icon, name, value, position);
	}
	
	@Override
	public void setPlayer(Player player) 
	{
		// TODO Auto-generated method stub
		this.player = player;
	}
	
	@Override
	public Position move(Position[][] grid, Position position) 
	{
		// TODO Auto-generated method stub
		if (grid[position.row][position.col] == null)
		{

			//Drops down the rows before plotting a piece (if the column is open)
			while (position.row < grid.length && grid[position.row][position.col] == null)
				position.row++;
			
			//Assigns position to disc
			this.position = position;
			
			//Assigns disc to position
			position.ruler = this;
			
			//Plots disc and position within the grid
			grid[--position.row][position.col] = position;
			

			//Returns position of most recent move
			return position;
		} 
		else
			return null; // No moves to make
	}
}
