package games;

// OVERVIEW:
// Implements a ship
//

class Ship extends Sprite {

	// Constants
	private static final double INITIAL_ENERGY_LEVEL = 100;
	private static final int INITIAL_SHIP_ROW = 1;
	private static final int INITIAL_SHIP_COL = 1;

	// Instance Variables/Objects
	private double energyLevel;
	private java.awt.Point prevPosition;

    // REQUIRES: GameGrid is set.
    // MODIFIES: energyLevel. See Sprite constructor for additional modifications
    // EFFECTS: Sets the energy level. Initialize prevPosition.
    //			See Sprite constructor for additional effects
	Ship(GameGrid g, String s) {
		super(INITIAL_SHIP_ROW, INITIAL_SHIP_COL, s, g);
		setEnergyLevel(INITIAL_ENERGY_LEVEL);
		prevPosition = new java.awt.Point(INITIAL_SHIP_ROW, INITIAL_SHIP_COL);
	}

    // REQUIRES: /
    // MODIFIES: energyLevel
    // EFFECTS: Sets the energy level to the provided value
	public void setEnergyLevel(double e) {
		energyLevel = e;
	}

    // REQUIRES: /
    // MODIFIES: /
    // EFFECTS: Returns the ship's energy level
	public double getEnergyLevel() {
		return energyLevel;
	}

	// REQUIRES: /
    // MODIFIES: energyLevel
    // EFFECTS: Increases the energy level by n percent
	public void increaseEnergyLevel(double n) {
		energyLevel = energyLevel + (energyLevel * (n / 100));
	}

	// REQUIRES: /
    // MODIFIES: energyLevel
    // EFFECTS: Decreases the energy level by n percent
	public void decreaseEnergyLevelPercentage(double n) {
		energyLevel = energyLevel - (energyLevel * (n / 100));
	}

	// REQUIRES: /
    // MODIFIES: energyLevel
    // EFFECTS: Decreases the energy level by n 
	public void decreaseEnergyLevel(double n) {
		energyLevel = energyLevel - n;
	}

	// REQUIRES: /
    // MODIFIES: /
    // EFFECTS:  Returns the ship's starting row
	public int getInitialRow() {
		return INITIAL_SHIP_ROW;
	}

	// REQUIRES: /
    // MODIFIES: /
    // EFFECTS:  Returns the ship's starting col
	public int getInitialCol() {
		return INITIAL_SHIP_COL;
	}

	// REQUIRES: prevPosition is set
    // MODIFIES: prevPosition
    // EFFECTS: Sets the x,y coordinate of the ship's previous position
	public void setPrevPosition(int r, int c) {
		prevPosition.setLocation(r, c);
	} 

	// REQUIRES: prevPosition is set
    // MODIFIES: prevPosition
    // EFFECTS: Returns the x,y coordinates of the ship's previous position
	public java.awt.Point getPrevPosition() {
		return prevPosition;
	}
 
}