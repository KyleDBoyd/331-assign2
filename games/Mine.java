package games;

// OVERVIEW:
// Implements a K-mine on the grid. Mines cannot be drawn on the stargate.
// See Sprite for additional details
//
//

class Mine extends Sprite {
	
	// Constants
	private static final int INITIAL_MINE_ROW = 1; // Placeholder
	private static final int INITIAL_MINE_COL = 1; // Placeholder

	// REQUIRES: GameGrid object is set
	// MODIFIES: See Sprite constructor for modifies
	// EFFECTS: See Sprite constructor for effects
	Mine(GameGrid g, String s) {
		super(INITIAL_MINE_ROW, INITIAL_MINE_COL, s, g);
	}

	// REQUIRES: /
	// MODIFIES: Updates the mine position
	// EFFECTS: Gets a random board position and draws the mine on the board.
	//			Makes sure the mine doesn't land in the star gate or on one of the stars
	//			protecting the gate
	public void draw() {
		int randRow, randCol;
		do {
			randRow = getMinePosition(grid.START_POINT, grid.HEIGHT - 1);
			randCol = getMinePosition(grid.START_POINT, grid.WIDTH - 1);
		} while(randRow == grid.HEIGHT - 1 && randCol == grid.WIDTH - 1);
		setPosition(randRow, randCol);
		super.draw();
	}

	// REQUIRES: /
	// MODIFIES: /
	// EFFECTS: Returns a random number greater than or equal to the min 
	//			and less than or equal to the max
	private int getMinePosition(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}


}