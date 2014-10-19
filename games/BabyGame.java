package games;

class BabyGame
    extends javax.swing.JPanel
/* Purpose: Draws a grid of buttons that can be used to implement a grid game.
*/
{
    public static final int HEIGHT=9;	// default height and width of the play area
    public static final int WIDTH=9;

    private int height;
    private int width;

    Location[][] grid;

    BabyGame() {
		super();

		height = HEIGHT+1;		// an extra header row and column
		width = WIDTH+1;
		setLayout(new java.awt.GridLayout(height,width));

		// Generate the grid
		grid = new Location[height][width];
		grid[0][0] = new Location(0, 0, this);
		for (int i = height-1; i >= 0; i--) {
		    for (int j = 0; j < width; j++) {
				grid[i][j] = new Location(i, j, this);
		    }
		}
		grid[0][0].setEnabled(false);
		for (int i = 1; i < height; i++) {
		    grid[i][0].setText("" + i);
		    grid[i][0].setEnabled(false);
		}
		for (int j = 1; j < width; j++) {
		    grid[0][j].setText("" + j);
		    grid[0][j].setEnabled(false);
		}

		// Render the grid in the panel - vertical order is
		//   reversed so the matrix appears in a
		//   "natural" way with origin at lower left
		for (int i = height-1; i >= 0; i--) {
		    for (int j = 0; j < width; j++) {
				add(grid[i][j]);
		    }
		}
    }

    void userMove(int row, int col) {
		System.out.println("You clicked on ("+row+","+col+")");
    }

}