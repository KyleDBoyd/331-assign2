package games;

// OVERVIEW:
// Handles the game logic of the BabyQ Game and user interaction
//

class BabyGame {

	// Constants
	private static final String MINE_CHARACTER = "K";
	private static final String STAR_GATE_CHARACTER = "*";
	private static final String SHIP_CHARACTER = "E";
	private static final int ENERGY_CHANGE = 10;
	private static final int MINE_ENERGY_CHANGE = 30;
	private static final int MINE_COUNT = 3;
	private static final int MINIMUM_ENERGY_LEVEL = 20;
	private static final String ENERGY_LEVEL_FAILURE = "Enery level below 20 units, " + 
													   "life support fails. Game over.";
	private static final String MOVE_LIMIT_EXCEEDED = "Move limit of 100 exceeded. Game over.";
	private static final String MINE_HIT = "K-mine hit! Energy level decreased by " +
										   " 30% and returned to the starting position";
    private static final String STAR_HIT = "You cannot land on stars! Please move again.";										  
	private static final String WINNER_NOTICE = "You win!!!";

	// Instance Variables/Objects
	private GameGrid grid;
	private Ship ship;
	private StarGate gate;
	private BabyQ babyQ;
	private DashBoard dashboard;
	private java.util.ArrayList<Mine> mines;
	private double moveCount;

	// REQUIRES: BabyQ(bq) object is set
    // MODIFIES: /
    // EFFECTS: Sets the BabyQ object for this class
	BabyGame(BabyQ bq) {
		babyQ = bq;
	}

	// REQUIRES: Ship, StarGate, and Dashboard classes are avaliable.
	// 			 Assumes the babyQ object extends JFrame
    // MODIFIES: grid, ship, gate, mines, moveCount, dashboard 
    // EFFECTS: Initializes the instance variables defined above and loads the dashboard
	public void initialize(GameGrid g) {
		grid = g;
		ship = new Ship(grid, SHIP_CHARACTER);
		gate = new StarGate(grid, STAR_GATE_CHARACTER);
		mines = new java.util.ArrayList<Mine>();
		moveCount = 0;
		dashboard = new DashBoard(this, ship);
		babyQ.add(dashboard, java.awt.BorderLayout.SOUTH);
	}

	// REQUIRES: \
    // MODIFIES: \ 
    // EFFECTS: returns the move count
    public double getMoveCount() {
    	return moveCount;
    }

	// REQUIRES: ship, mines, dashboard are set
    // MODIFIES: ship, mines, dashboard
    // EFFECTS: Handles all of the game logic when a user clicks a cell
    //			This function does the following:
    //				Increments the move count
    //				Updates/Resets the dashboard notification
    //				If the ship stays in the same position, the energy level is increased
    //				If the ship moves, k-mines are placed, checks if a mine was hit. Decrements the energy
   	//								   based on mine hits and distance moved

    //
    public void userMove(int row, int col) {
    	
    	// Don't allow user to move onto stars
		if(row == gate.getGateCol()-1 || col == gate.getGateRow()-1) {
			dashboard.setNotification(STAR_HIT);
		} else {
			// Reset Dashboard Notification
	    	dashboard.setNotification("");
	    	moveCount++;

			// Staying in current position
			if(row == ship.getRow() && col == ship.getCol()) {
				ship.increaseEnergyLevel(ENERGY_CHANGE);
			// Ship attempted move
			} else {

				for(int i = 0; i < MINE_COUNT; i++) {
					mines.add(new Mine(grid, MINE_CHARACTER));
				}

				// Set ships previous location before redrawing
				ship.setPrevPosition(ship.getRow(), ship.getCol());

				// Erase current ship and redraw in the new location
				ship.reDraw(row, col);

				// Remove base 10% for moving
				ship.decreaseEnergyLevelPercentage(ENERGY_CHANGE);

				// Calculate energy used to move and decrement accordingly
				ship.decreaseEnergyLevel(calculateEnergyUsed(ship.getPrevPosition(), ship.getPosition()));

				// Ship lands on mine
				for(int i = 0; i < mines.size(); i++) {
					if(mines.get(i).getRow() == row && mines.get(i).getCol() == col) {
						ship.decreaseEnergyLevel(MINE_ENERGY_CHANGE);
						ship.reDraw(ship.getInitialRow(), ship.getInitialCol());
						dashboard.setNotification(MINE_HIT);
						break;
					}
				}

				// Energy Level below minimum. Game over.
				if(ship.getEnergyLevel() < MINIMUM_ENERGY_LEVEL) {
					gameOver(ENERGY_LEVEL_FAILURE);
				}else if(gate.getGateRow() == ship.getRow() && gate.getGateCol() == ship.getCol()) {
					gameOver(WINNER_NOTICE);
				}
			}

			// Move count limit exceeded. Game over.
			if(moveCount > 100) {
				gameOver(MOVE_LIMIT_EXCEEDED);
			}

			// Update dashboard
			dashboard.setEnergyLabel(ship.getEnergyLevel());
			dashboard.setMoveLabel(moveCount);		
		}
    	
    }

	// REQUIRES: grid and dashboard are set
    // MODIFIES: grid, dashboard
    // EFFECTS:	Disables all cells on the grid and updates the notification board
    //			This function can be used for a win or loss.
    private void gameOver(String s) {
    	// Disable all cells
    	grid.disableAllCells();
    	// Set dashboard notification
    	dashboard.setNotification(s);

    }

	// REQUIRES: p and n x,y coordinates are set
    // MODIFIES: / 
    // EFFECTS:	Uses the pythagorean theorem to calculate the distance from 2 points
    //			c^2 = a^2 + b^2. It then multiplies the distance by 100 to get the energy used.
    private double calculateEnergyUsed(java.awt.Point p, java.awt.Point n) {
    	return Math.sqrt((Math.pow((n.x - p.x), 2) + Math.pow((n.y - p.y), 2))) * 100;
    }

}