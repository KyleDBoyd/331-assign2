package games;
// Purpose: Draws a grid of buttons that can be used to implement a grid game.
class BabyGame {

	// Constants
	private static final String MINE_CHARACTER = "K";
	private static final String STAR_GATE_CHARACTER = "*";
	private static final String SHIP_CHARACTER = "E";
	private static final int ENERGY_CHANGE = 10;
	private static final int MINE_COUNT = 3;

	private GameGrid grid;
	private Ship ship;
	private StarGate gate;
	private Mine mines[];

	public void initialize() {
		ship = new Ship(grid, SHIP_CHARACTER);
		gate = new StarGate(grid, STAR_GATE_CHARACTER);
	}

    public void setGrid(GameGrid g) {
    	grid = g;
    }

    public void userMove(int row, int col) {

		// Staying in current position
		if(row == ship.getRow() && col == ship.getCol()) {
			ship.increaseEnergyLevel(ENERGY_CHANGE);
		// Ship attempted move
		} else {
			ship.decreaseEnergyLevel(ENERGY_CHANGE);
			mines = new Mine[MINE_COUNT];
			for(int i = 0; i < MINE_COUNT; i++) {
				mines[i] = new Mine(grid, MINE_CHARACTER);
			}

			// Erase current ship and redraw in the new location
			ship.erase();
			ship.setRow(row);
			ship.setCol(col);
			ship.draw();
		}
    }

}