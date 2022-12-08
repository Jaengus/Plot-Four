package plot_four;

import javafx.scene.Node;

import game.Position;
import game.Position_Manager;
import game.Unit;

public class Disc extends Unit
{
	public Disc(Node icon, String name, double value) 
	{
		super(icon, name, value);
	}

	public Position move(Position[][] grid, Position pos) 
	{
		if (grid[pos.row][pos.col] == null)
		{

			//Drops down the rows before plotting a piece (if the column is open)
			while (pos.row < grid.length && grid[pos.row][pos.col].ruler == null)
				pos.row++;
			
			grid[--pos.row][pos.col] = pos;
			
			//Plots the unit in the matrix
			grid[pos.row][pos.col].ruler = this; 

			//Returns position of most recent move
			return pos;
		} 
		else
			return null; // moves to make
	}
}
