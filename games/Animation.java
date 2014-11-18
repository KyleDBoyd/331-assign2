package games;

// OVERVIEW:
//
//

class Animation {
	// Constants
	private static final int ANIMATION_DELAY = 20;
	private static final int ANIMATION_START_ROW = 1;
	private static final int ANIMATION_START_COL = 1;
	private static final int UP_DIRECTION = 1;
	private static final int RIGHT_DIRECTION = 2;
	private static final int DOWN_DIRECTION = 3;
	private static final int LEFT_DIRECTION = 4;
	private static final String ANIMATION_CHARACTER = "&";

	// Class/Instance Variables
	private GameGrid grid;
	private javax.swing.Timer timer;
	private java.awt.event.ActionListener animation;
	private int row, col, animationDirection, gridHeight, gridWidth, startRow, startCol;

	// REQUIRES: \
	// MODIFIES: \
	// EFFECTS: \
	Animation(GameGrid g) {
		grid = g;
		initAnimation();
		animation = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	gridAnimation();
		    }
		};
		timer = new javax.swing.Timer(ANIMATION_DELAY, animation);
	}

	// REQUIRES: \
	// MODIFIES: \
	// EFFECTS: \
	public void startAnimation() {
		grid.clearGrid();
		timer.start();
	}

	// REQUIRES: \
	// MODIFIES: \
	// EFFECTS: \
	public void stopAnimation() {
		timer.stop();
	}

	// REQUIRES: \
	// MODIFIES: \
	// EFFECTS: \
	public void resetAnimation() {
		grid.clearGrid();
		initAnimation();
	}

	// REQUIRES: \
	// MODIFIES: \
	// EFFECTS: \
	private void gridAnimation() {

		if(grid.grid[row][col].getText() == ANIMATION_CHARACTER) {
			resetAnimation();
		}
		grid.grid[row][col].setText(ANIMATION_CHARACTER);

		// Move based on animation direction
		switch (animationDirection) {
			case UP_DIRECTION:
				row++;
				break;
			case RIGHT_DIRECTION:
				col++;
				break;
			case DOWN_DIRECTION:
				row--;
				break;
			case LEFT_DIRECTION:
				col--;
				break;
		}

		// Direction change
		if(col == startCol+1 && row == startRow) {
			gridHeight--;
			gridWidth--;
			startRow++;
			startCol++;
			row++;
			col++;
			animationDirection = UP_DIRECTION;
		}else if(row == startRow && animationDirection != LEFT_DIRECTION) {
			animationDirection = LEFT_DIRECTION;
		} else if(col == startCol && animationDirection != UP_DIRECTION) {
			animationDirection = UP_DIRECTION;
		} else if(row == gridHeight && animationDirection != RIGHT_DIRECTION) {
			animationDirection = RIGHT_DIRECTION;
		} else if(col == gridWidth && animationDirection != DOWN_DIRECTION) {
			animationDirection = DOWN_DIRECTION;
		} 

		
		
	}


	// REQUIRES: \
	// MODIFIES: \
	// EFFECTS: \
	private void initAnimation() {
		row = ANIMATION_START_ROW;
		col = ANIMATION_START_COL;
		startRow = row;
		startCol = 0;
		animationDirection = UP_DIRECTION;
		gridHeight = grid.HEIGHT;
		gridWidth = grid.WIDTH;
	}
}