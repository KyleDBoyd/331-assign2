package games;

// OVERVIEW:
//
//
//
//

class Sprite {

    // Instance Variables/Objects
    protected GameGrid grid;
    protected String sprite;
    protected java.awt.Point location;

    // REQUIRES: GameGrid is set. Assumes the provided row/col are within the grid bounds
    // MODIFIES: Sets location variable. Sets sprite and grid objects
    // EFFECTS: Initializes the location and draws the sprite to the grid
    Sprite(int r, int c, String s, GameGrid g) {
        location = new java.awt.Point(r, c);
        sprite = s;
        grid = g;
        draw();
    }

    // REQUIRES: Grid is set and current row/col are withing grid bounds.
    // MODIFIES: grid text
    // EFFECTS: Draws the sprite string in the current row/col of the grid
    public void draw() {
        grid.grid[getRow()][getCol()].setText(sprite);
    }

    // REQUIRES: Grid is set and current row/col are withing grid bounds.
    // MODIFIES: grid text
    // EFFECTS: Erases the sprite string in the current row/col of the grid
    public void erase() {
        grid.grid[getRow()][getCol()].setText("");
    }

    // REQUIRES: location Point is set. Provided r, c are within grid bounds.
    // MODIFIES: location, grid text
    // EFFECTS: Erases the current sprite and redraws it in the provided x and y coordinate.
    //          This function also updates the x and y cooridinate. See SetLocation().
    public void reDraw(int r, int c) {
        this.erase();
        location.setLocation(r, c);
        this.draw();
    }

    // REQUIRES: location Point is set
    // MODIFIES: / 
    // EFFECTS: Returns 
    public java.awt.Point getPosition() {
        return location;
    }

    // REQUIRES: location Point is set
    // MODIFIES: / 
    // EFFECTS: Returns the x coordinate of the sprite location
    public int getRow() {
        return location.x;
    }

    // REQUIRES: location Point is set
    // MODIFIES: / 
    // EFFECTS: returns the y coordinate of the sprite location
    public int getCol() {
        return location.y;
    }

    // REQUIRES: location Point is set
    // MODIFIES: location
    // EFFECTS: Updates the sprites location x and y coordinates
    public void setPosition(int r, int c) {
        location.setLocation(r, c);
    }

}


