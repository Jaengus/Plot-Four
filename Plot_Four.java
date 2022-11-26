package plot_four;

import game.Monad;
import game.Grid;
import boardgame.Boardgame;
import boardgame.Unit;
import boardgame.Position;
import plot_four.Disc;

public class Plot_Four extends Boardgame
{
	@Override
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
	
	@Override
	protected void setUnits(int rows, int cols) 
	{
		Monad[][] monads = new Disc[rows][cols];
		brigade = new Unit(monads);
	}
	
	private Disc[][] discs(Monad[][] monads) {
		return (Disc[][])monads;
	}
	
	@Override
	protected void setGame() {
		setUnits(2,21);
		setGrid(6,7);
	}

	@Override
	public void play() 
	{
	}
}
