import java.util.ArrayList;

public class ToasterSlot {
	ArrayList<Heater> heaters = new ArrayList<Heater>();
	boolean isEngaged = false;
	int time = 0;
	int DEFAULT_NUMBER_OF_HEATERS = 1;
	String slotId = "";
	
	public ToasterSlot(String id) {
		this.slotId = id;
		
		for(int i=0;i<DEFAULT_NUMBER_OF_HEATERS;i++) {
			heaters.add(new Heater());
		}
	}
	
	public ToasterSlot(String id, int numOfHeaters) {		
		this.slotId = id;
		
		for(int i=0;i<numOfHeaters;i++) {
			heaters.add(new Heater());
		}
	}
	
	public ToasterSlot(String id, int numOfHeaters, int maxHeat) {
		this.slotId = id;
		
		for(int i=0;i<numOfHeaters;i++) {
			heaters.add(new Heater(maxHeat));
		}
	}
	
	public ToasterSlot(String id, int numOfHeaters, int maxHeat, int minHeat) {
		this.slotId = id;
		
		for(int i=0;i<numOfHeaters;i++) {
			heaters.add(new Heater(maxHeat, minHeat));
		}
	}
	
	public ArrayList<Heater> getHeaters() {
		return this.heaters;
	}
	
	public void setIsEnggaged(boolean isEngaged) {
		if(isEngaged) {
			System.out.println("Slot " + this.slotId + " is engaging");
		} else {
			System.out.println("Slot " + this.slotId + " is disengaging");
		}
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
	
	public void setCurrentHeat(int currentHeat) {
		for(Heater h: heaters) {
			h.setCurrentHeat(currentHeat);
		}
	}
	
	public double getIntensity() {
		double intensity = 0;
		for(Heater h: this.heaters) {
			intensity+=time*h.currentHeat;
		}
		return intensity;
	}
}
