package games;

// OVERVIEW:
//
//
//
//

class StarGate extends Sprite {

	// Constants	
	private static final int INITIAL_GATE_ROW = 9;
	private static final int INITIAL_GATE_COL = 9;

    // REQUIRES: GameGrid is set.
    // MODIFIES: See Sprite constructor 
    // EFFECTS: See Sprite constructor
	StarGate(GameGrid g, String s) {
		super(INITIAL_GATE_ROW, INITIAL_GATE_COL, s, g);
	}

	// REQUIRES: grid is set
    // MODIFIES: grid text
    // EFFECTS: Overrides the sprite draw function. Draws the gate sprites around the 
    //			initial gate row/col
	public void draw() {
		grid.grid[getRow() - 1][getCol()].setText(sprite);
		grid.grid[getRow()][getCol() - 1].setText(sprite);
		grid.grid[getRow() - 1][getCol() - 1].setText(sprite);
	}

}