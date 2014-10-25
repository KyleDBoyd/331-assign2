package games;

class StarGate extends Sprite {
	
	private static final int INITIAL_SHIP_ROW = 9;
	private static final int INITIAL_SHIP_COL = 9;

	StarGate(GameGrid g, String s) {
		super(INITIAL_SHIP_ROW, INITIAL_SHIP_COL, s, g);
	}

	// Override Sprite draw
	public void draw() {
		grid.grid[row - 1][col].setText(sprite);
		grid.grid[row][col - 1].setText(sprite);
		grid.grid[row - 1][col - 1].setText(sprite);
	}

}