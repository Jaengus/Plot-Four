package game;

import javafx.scene.layout.GridPane;

public class Position_Manager extends GridPane
{
	public Position[][] positions;
	
	public Position_Manager(Position[][] positions) 
	{
		this.positions = positions;
	}
}
