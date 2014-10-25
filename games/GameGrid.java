package games;

class GameGrid extends javax.swing.JPanel {

    public static final int HEIGHT = 9;	// default height and width of the play area
    public static final int WIDTH = 9;
    public static final int START_POINT = 1;

    private int height;
    private int width;

    Location[][] grid;
    BabyGame game;

    GameGrid() {
		super();

		game = new BabyGame();

		height = HEIGHT+1;		// an extra header row and column
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
		game.setGrid(this);
		game.initialize();

    }
}