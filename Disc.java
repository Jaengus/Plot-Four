package plot_four;

import javafx.scene.Node;
import boardgame.Unit;
import boardgame.Position;

public class Disc extends Unit
{
	public Disc(Node icon, String name, double value) {
		super(icon, name, value);
	}

	public boolean move(Position[][] grid, Position pos) {
		if (grid[pos.row][pos.col].unit == null) {

			//Drops down the rows before plotting a piece (if the column is open)
			while (pos.row < grid.length && grid[pos.row][pos.col].unit == null)
				pos.row++;
			
			//Plots the unit in the matrix
			grid[--pos.row][pos.col].unit = this; 

			//Checks to see if there is a victor or if there are no more moves left
			if (win(grid, pos, -1, 0, 0) || ++n >= 42) {
				return false;
			}
			
			//Changes whose turn it is
			turn = (turn < 1) ? 1 : 0; 

			//Returns that there are moves to make
			return true;
		}
		else if (n < 42)
			return true; //Column is empty but there are still moves to make 
		else
			return false; // No more moves to make
	}
}
}
