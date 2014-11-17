package games;

// OVERVIEW:
// Implements a top level window to contain the BabyQ game.
//

class BabyQ extends javax.swing.JFrame
{
    // REQUIRES: \
    // MODIFIES: JFrame and JFrame contents
    // EFFECTS: Initializes the game and game grid
    BabyQ() {
		initUI();
    }

    // REQUIRES: \
    // MODIFIES: Jframe and Jframe contents
    // EFFECTS: Set's the game title and Jframe configurations. Initializes the game and gamegrid
    private void initUI() {
        
        setTitle("Baby Q");
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        add(new GameGrid(this));

	    setSize(1000,1000);
        setLocationRelativeTo(null);
    }

    // REQUIRES: \
    // MODIFIES: bq
    // EFFECTS: Initializes BabyQ and displays the game board
    public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {

    		    BabyQ bq = new BabyQ();
    		    bq.setVisible(true);
    		}
	    });
    }
}
