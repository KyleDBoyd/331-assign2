package games;

class Location
    extends javax.swing.JButton
    implements java.awt.event.ActionListener
/* Purpose: Implements a button that knows its location in a grid of
     buttons.  When the button is clicked, it calls userMove on the
     instance of BabyGame passed in on creation and passes its row and
     column.
*/
{
    private final int row;
    private final int col;
    private final BabyGame game;

    Location(int r, int c, BabyGame g) {
    	super();
    	row = r;
    	col = c;
        game = g;
    	addActionListener(this);
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) { 
	   game.userMove(row, col);
    } 

}