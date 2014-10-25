package games;

class Sprite {

    protected GameGrid grid;
    protected String sprite;
    protected int row, col;

    Sprite(int r, int c, String s, GameGrid g) {
        row = r;
        col = c;
        sprite = s;
        grid = g;
        draw();
    }

    public void draw() {
        grid.grid[row][col].setText(sprite);
    }

    public void erase() {
        grid.grid[row][col].setText("");
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int c) {
        col = c;
    }

    public void setRow(int r) {
        row = r;
    }

}


