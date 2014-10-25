package games;

class Ship extends Sprite {

	// Constants
	private static final int INITIAL_ENERGY_LEVEL = 100;
	private static final int INITIAL_SHIP_ROW = 1;
	private static final int INITIAL_SHIP_COL = 1;

	// Variables
	private int energyLevel;

	Ship(GameGrid g, String s) {
		super(INITIAL_SHIP_ROW, INITIAL_SHIP_COL, s, g);
		setEnergyLevel(INITIAL_ENERGY_LEVEL);
	}

	public void setEnergyLevel(int e) {
		energyLevel = e;
	}

	public int getEnergyLevel(int e) {
		return energyLevel;
	}

	// Increase by a percentage
	public void increaseEnergyLevel(int n) {
		energyLevel = energyLevel + energyLevel * (n / 100);
	}

	// Decrease by a percentage
	public void decreaseEnergyLevel(int n) {
		energyLevel = energyLevel - energyLevel * (n / 100);
	}

}