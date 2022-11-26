package plot_four;

import boardgame.Boardgame;
import boardgame.Unit;
import game.Monad;
import game.Grid;
import boardgame.Position;

public class Plot_Four extends Boardgame
{
	protected void setGrid(int rows, int cols) 
	{
		Position[][] positions = new Position[rows][cols];
		grid = new Grid(positions);
		
		for(int row = 0; row < rows; row++) 
		{
			for(int col = 0; col < cols; col++) 
			{
				positions[row][col] = new Position(null, "", 0, null);
			}
		}
	}
	
	protected void setUnits(int rows, int cols) 
	{
		
	}
}
