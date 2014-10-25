package games;

class Mine extends Sprite {
	
	private static final int INITIAL_MINE_ROW = 1; // Placeholder
	private static final int INITIAL_MINE_COL = 1; // Placeholder

	Mine(GameGrid g, String s) {
		super(INITIAL_MINE_ROW, INITIAL_MINE_COL, s, g);
	}

	public void draw() {
		// Get a random board position and draw
		int randRow = getMinePosition(grid.START_POINT, grid.HEIGHT);
		int randCol = getMinePosition(grid.START_POINT, grid.WIDTH);
		setRow(randRow);
		setCol(randCol);
		grid.grid[row][col].setText(sprite);
	}

	// generated a random mine pos based on the provided min/max
	private int getMinePosition(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}


}