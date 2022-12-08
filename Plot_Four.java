package plot_four;

import javafx.scene.image.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import game.Monad;
import game.Position;
import game.Position_Manager;
import game.Unit_Manager;
import boardgame.Boardgame;
import plot_four.Disc;

public class Plot_Four extends Boardgame
{
	public Plot_Four(String title, String serial, double price, boolean purchased) 
	{
		super(title, serial, price, purchased);
	}

	@Override
	protected void setGrid(int rows, int cols) 
	{
		Position[][] positions = new Position[rows][cols];
		position_Manager = new Position_Manager(positions);
		
		for(int row = 0; row < rows; row++) 
		{
			for(int col = 0; col < cols; col++) 
			{
				positions[row][col] = new Position(null, null, "", 0);
			}
		}
	}
	
	@Override
	protected void setUnits(int rows, int cols) 
	{
		Monad[][] discs = new Disc[rows][cols];
		brigade = new Unit_Manager(discs);
		
		for(int row = 0; row < rows; row++) 
		{
			for(int col = 0; col < cols; col++) 
			{
				if(col < cols)
				{
					discs[row][col] = new Disc(new Circle(), "R", 1);
				}
				else
				{
					discs[row][col] = new Disc(new Circle(), "Y", 2);
				}
			}
		}
	}
	
	@Override
	protected void setGame() 
	{
		setUnits(2,21);
		setGrid(6,7);
	}

	@Override
	public void play() 
	{
	}

	@Override
	protected boolean win(Position[][] grid, Position pos, int v, int u, int n) 
	{
		int r = pos.row, c = pos.col, count = 0;

		//Checks half a vertical, diagonal, or horizontal line based on the arguments assigned to r and c
		while ((r >= 0 && c >= 0) && (r < grid.length && c < grid[r].length)) {

			if (grid[r][c].ruler == this)
				count++;
			else
				break;

			r += v;
			c += u;
		}
		
		//Re-assigns the values of y and x to r and c to check the other half of the line
		r = pos.row; 
		c = pos.col; 

		while ((r >= 0 && c >= 0) && (r < grid.length && c < grid[r].length)) {

			if (grid[r][c].ruler == this && (r != pos.row || c != pos.col))
				count++;
			else if (r != pos.row || c != pos.col)
				break;

			r += v * -1;
			c += u * -1;

		}

		//Recursively checks the area centering a unit before returning the value of the unit
		//that won or 0.
		if (count == 4)
			return true;
		else if (n < 4) {
			if (v + u == -1)
				return win(grid, pos, v, 1, ++n);
			else if (v + u == 0)
				return win(grid, pos, 0, u, ++n);
			else
				return win(grid, pos, 1, u, ++n);
		}
		else
			return false;
	}
}
