package games;

// OVERVIEW:
// Implements a panel within the top level frame that 
// contains the dashboard labels
//
//

class DashBoard extends javax.swing.JPanel
				implements java.awt.event.ActionListener
{
	
	// Constants
	private static final String RESTART_BUTTON_TEXT = "Restart Game";

	// Instance Variables/Objects
	private BabyGame babyGame;
	private Ship ship;
	private javax.swing.JLabel energyLevel, moves, notice;
	private javax.swing.JButton reset;

	// REQUIRES: Babygame and Ship objects are set
	// MODIFIES: Sets the dashboard labels and initializes the Ship and BabyGame objects
	// EFFECTS:  Sets the default label data and adds them to the JPanel
	DashBoard(BabyGame g, Ship s) {
		super();
		babyGame = g;
		ship = s;
		this.setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
		energyLevel = new javax.swing.JLabel("");
	    moves = new javax.swing.JLabel("");
	    notice = new javax.swing.JLabel("");
	    reset = new javax.swing.JButton(RESTART_BUTTON_TEXT);
		reset.addActionListener(this);
	    setEnergyLabel(ship.getEnergyLevel());
	    setMoveLabel(babyGame.getMoveCount());
	    add(energyLevel);
	    add(moves);
	    add(notice);
	    add(reset);
	}

	// REQUIRES: /
	// MODIFIES: energyLevel
	// EFFECTS: Updates the energy level on the dashboard. Rounds to the nearest whole number.
	public void setEnergyLabel(double e) {
		energyLevel.setText("Energy level: " + Math.round(e));
	}

	// REQUIRES: /
	// MODIFIES: moves
	// EFFECTS: Updates the moves label on the dashboard. Rounds to the nearest whole number.
	public void setMoveLabel(double e) {
		moves.setText("Moves: " + Math.round(e));
	}

	// REQUIRES: /
	// MODIFIES: notice
	// EFFECTS: Updates the notification text on the dashboard to display the provided string.
	public void setNotification(String s) {
		notice.setText(s);
	}

	// REQUIRES: babyGame is set
	// MODIFIES: babyGame
	// EFFECTS: Calls the babyGame reset method to reset the game
	public void actionPerformed(java.awt.event.ActionEvent e) { 
		babyGame.resetGame();
	}

}