package plot_four;

import javafx.scene.image.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import game.Monad;
import game.Player;
import game.Position;
import game.Position_Manager;
import game.Unit;
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
	}
	
	@Override
	protected void setUnits(int rows, int cols) 
	{
		Unit[][] discs = new Disc[rows][cols];
		
		Player[] player1 = {new Player("Crow", "@capitanchuro")};
		Player[] player2 = {new Player("Jaengus", "@jaengus")};
		
		discs[0][0] = new Disc(player1, new Circle(), "Red", 1, null);
		discs[1][0] = new Disc(player2, new Circle(), "Yellow", 2, null);
		
		brigade = new Unit_Manager(discs);
	}
	
	@Override
	protected void setPlayers() 
	{
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void setGame() 
	{
		setUnits(2,21);
		setGrid(6,7);
		setPlayers();
	}

	@Override
	protected Player[] win(Position[][] grid, Position position, int v, int u, int n) 
	{
		int row = position.row, col = position.col, count = 0;

		//Checks half a vertical, diagonal, or horizontal line based on the arguments assigned to r and c
		while ((row >= 0 && col >= 0) && (row < grid.length && col < grid[row].length)) 
		{

			if (grid[row][col].ruler == position.ruler)
				count++;
			else
				break;

			row += v;
			col += u;
		}
		
		//Re-assigns the values of y and x to r and c to check the other half of the line
		row = position.row; 
		col = position.col; 

		while ((row >= 0 && col >= 0) && (row < grid.length && col < grid[row].length)) {

			if (grid[row][col].ruler == position.ruler && (row != position.row || col != position.col))
				count++;
			else if (row != position.row || col != position.col)
				break;

			row += v * -1;
			col += u * -1;

		}

		//Recursively checks the area centering a unit before returning the value of the unit
		//that won or 0.
		if (count == 4)
			return position.players;
		else if (n < 4) {
			if (v + u == -1)
				return win(grid, position, v, 1, ++n);
			else if (v + u == 0)
				return win(grid, position, 0, u, ++n);
			else
				return win(grid, position, 1, u, ++n);
		}
		else
			return null;
	}
	
	@Override
	public void play() 
	{
	}
}
