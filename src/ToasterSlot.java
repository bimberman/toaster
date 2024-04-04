
public class ToasterSlot {
	Heater[] heaters = null;
	boolean isEngaged = false;
	int time = 0;
	int DEFAULT_NUMBER_OF_HEATERS = 1;
	
	public ToasterSlot() {
		this.heaters = new Heater[DEFAULT_NUMBER_OF_HEATERS];
		
		for(Heater h: this.heaters) {
			h = new Heater();
		}
	}
	
	public ToasterSlot(int numOfHeaters) {
		this.heaters = new Heater[numOfHeaters];
		
		for(Heater h: this.heaters) {
			h = new Heater();
		}
	}
	
	public ToasterSlot(int numOfHeaters, int maxHeat) {
		this.heaters = new Heater[numOfHeaters];
		
		for(Heater h: this.heaters) {
			h = new Heater(maxHeat);
		}
	}
	
	public ToasterSlot(int numOfHeaters, int maxHeat, int minHeat) {
		this.heaters = new Heater[numOfHeaters];
		
		for(Heater h: this.heaters) {
			h = new Heater(maxHeat, minHeat);
		}
	}
	
	public Heater[] getHeaters() {
		return this.heaters;
	}
	
	public void setIsEnggaged(boolean isEngaged) {
		this.isEngaged = isEngaged;
	}
	
	public boolean getIsEnggaged() {
		return this.isEngaged;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getIntensity() {
		int intensity = 0;
		for(Heater h: this.heaters) {
			intensity+=time*h.currentHeat;
		}
		return intensity;
	}
}
