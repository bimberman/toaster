
public class Heater {
	int minHeat = 0;
	int maxHeat = 0;
	int currentHeat = 0;
	int DEFAULT_MAX_HEAT = 10;

	public Heater() {
		this.maxHeat = DEFAULT_MAX_HEAT;
	}
	
	public Heater(int maxHeat) {
		this.maxHeat = maxHeat;
	}
	
	public Heater(int maxHeat, int minHeat) {
		this.maxHeat = maxHeat;
		this.minHeat = minHeat;
	}
	
	public void setCurrentHeat(int heat) {
		this.currentHeat = heat;
	}
	
	public int getCurrentHeat() {
		return this.currentHeat;
	}
	
	public int getMinHeat() {
		return this.minHeat;
	}
	
	public int getMaxHeat() {
		return this.maxHeat;
	}
}
