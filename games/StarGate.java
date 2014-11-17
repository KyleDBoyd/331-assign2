package games;

// OVERVIEW:
// Implements a stargate sprite and draws it on the grid.
// See Sprite class for additional details.
//

class StarGate extends Sprite {

	// Constants	
	private static final int INITIAL_GATE_ROW = 11;
	private static final int INITIAL_GATE_COL = 15;

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

    // REQUIRES: /
    // MODIFIES: /
    // EFFECTS: Returns the gate row 
	public int getGateRow() {
		return INITIAL_GATE_ROW;
	}

	// REQUIRES: /
    // MODIFIES: /
    // EFFECTS: Returns the gate col 
	public int getGateCol() {
		return INITIAL_GATE_COL;
	}





}