package games;

// OVERVIEW:
// Implements a button that knows its location in a grid of
// buttons.  When the button is clicked, it calls userMove on the
// instance of BabyGame passed in on creation and passes its row and
// column.

class Location
    extends javax.swing.JButton
    implements java.awt.event.ActionListener
{
    // Instance Variables/Objects
    private final int row;
    private final int col;
    private final BabyGame game;

    // REQUIRES: BabyGame is set 
    // MODIFIES: sets the row,col, and game instance variables
    // EFFECTS: Initializes the variables and adds an action listener to the current location
    Location(int r, int c, BabyGame g) {
    	super();
    	row = r;
    	col = c;
        game = g;
    	addActionListener(this);
    }
    
    // REQUIRES: game is set
    // MODIFIES: game 
    // EFFECTS:  calls the userMove function on the current cell
    public void actionPerformed(java.awt.event.ActionEvent e) { 
	   game.userMove(row, col);
    } 

}