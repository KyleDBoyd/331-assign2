package games;

// OVERVIEW:
// Draws a grid of buttons that can be used to implement a grid game.
//

class GameGrid extends javax.swing.JPanel {

	// Constants
    public static final int HEIGHT = 11;	// default height and width of the play area
    public static final int WIDTH = 15;
    public static final int START_POINT = 1;

	// Instance Variables/Objects
    private int height;
    private int width;
    protected Location[][] grid;
    private BabyGame game;
    private BabyQ babyQ;

	// REQUIRES: babyQ is set
    // MODIFIES: game, grid
    // EFFECTS: Initializes the grid and creates the game
    GameGrid(BabyQ bq) {
		super();

		babyQ = bq;
		game = new BabyGame(babyQ);

		// an extra header row and column
		height = HEIGHT+1;		
		width = WIDTH+1;
		setLayout(new java.awt.GridLayout(height,width));

		// Generate the grid
		grid = new Location[height][width];
		grid[0][0] = new Location(0, 0, game);
		for (int i = height-1; i >= 0; i--) {
		    for (int j = 0; j < width; j++) {
				grid[i][j] = new Location(i, j, game);
		    }
		}
		grid[0][0].setEnabled(false);
		for (int i = 1; i < height; i++) {
		    grid[i][0].setText("" + i);
		    grid[i][0].setEnabled(false);
		}

		for (int i = 1; i < width; i++) {
			grid[0][i].setText("" + i);
		    grid[0][i].setEnabled(false);
		}

		// Render the grid in the panel - vertical order is
		// reversed so the matrix appears in a
		// "natural" way with origin at lower left
		for (int i = height-1; i >= 0; i--) {
		    for (int j = 0; j < width; j++) {
				add(grid[i][j]);
		    }
		}

		// Pass the Grid to the game and initialize the game
		game.initialize(this);
    }

	// REQUIRES: grid is set
    // MODIFIES: grid
    // EFFECTS: Disables all cells in the grid. The user can no longer click on the cells.
    public void disableAllCells() {
    	for(int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {
    			grid[i][j].setEnabled(false);
    		}
    	}
    }

    // REQUIRES: grid is set
    // MODIFIES: grid
    // EFFECTS: Clears the grid and ensures the cells are enabled
   	public void clearGrid() {
    	for(int i = 1; i < height; i++) {
    		for (int j = 1; j < width; j++) {
    			grid[i][j].setText("");
    			grid[i][j].setEnabled(true);
    		}
    	}
    }
}