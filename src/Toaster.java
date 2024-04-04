import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

enum HeatLevel {
	  LOW,
	  MEDIUM,
	  HIGH
}

public class Toaster {
	ToastableItem[] items = null;
	int numOfSlots = 0;
	int[] maxHeat = null;
	int[] minHeat = null;
	int[] currentHeat = null;
	int[] time = null;
	boolean isPoweredOn = false;
	boolean[] isEngaged = null;
	HashMap<Integer, Integer[]> groupingMap = new HashMap<Integer, Integer[]>();
	HashMap<Integer, Integer[]> indexToGroupingIdMap = new HashMap<Integer, Integer[]>();
	
	public Toaster(int numOfSlots, int maxHeat) {
		this.numOfSlots = numOfSlots;
		
		this.maxHeat = new int[numOfSlots];
		this.minHeat = new int[numOfSlots];
		this.currentHeat = new int[numOfSlots];
		this.isEngaged = new boolean[numOfSlots];
		this.items = new ToastableItem[numOfSlots];

		Arrays.fill(this.maxHeat, maxHeat);
		Arrays.fill(this.minHeat, 0);
		Arrays.fill(this.currentHeat, 0);
		Arrays.fill(this.isEngaged, false);
	}
	
	public Toaster(int numOfSlots, int maxHeat, int minHeat) {
		this.numOfSlots = numOfSlots;
		
		this.maxHeat = new int[numOfSlots];
		this.minHeat = new int[numOfSlots];
		this.currentHeat = new int[numOfSlots];
		this.isEngaged = new boolean[numOfSlots];
		this.items = new ToastableItem[numOfSlots];
		
		Arrays.fill(this.maxHeat, maxHeat);
		Arrays.fill(this.minHeat, minHeat);
		Arrays.fill(this.currentHeat, 0);
		Arrays.fill(this.isEngaged, false);
	}
	
	public int groupItems(Integer[] indecies, ToastableItem[] items) {
		int groupId = groupingMap.size();
		groupingMap.put(groupId, indecies);
		
		for(int i=0;i<indecies.length;i++) {
			int index = indecies[i].intValue();
			this.items[index] = items[i];
		}
		
		return groupId;
	}
	
	private void engageItem(int index, int currentHeat, ToastableItem item) {
		this.isEngaged[index] = true;
		this.currentHeat[index] = currentHeat;
		this.items[index] = item;
		item.isToasting = true;
	}
	
	private void disengageItem(int index, int toastedAmount) {
		this.isEngaged[index] = false;
		this.currentHeat[index] = 0;
		items[index].isToasting = false;
		items[index].isToasted = true;
		items[index].toastedAmount = toastedAmount;
		this.items[index] = null;
	}

	public void toastItems(int[] times, Integer[] indecies, int[] currentHeats, ToastableItem[] items) {
		// some king of timing function is needed here
		System.out.println("Not Grouped, Toasting:");
		for(int i=0;i<indecies.length;i++) {
			engageItem(indecies[i].intValue(), currentHeats[i], items[i]);
			items[i].printState();
		}

//		Scanner input = new Scanner(System.in);
//	    String cont = input.nextLine();
//	    while(!cont.equals("y")) {
//	        cont = input.nextLine();
//	    }
//	    input.close();
	    for(int i=0;i<indecies.length;i++) {
			disengageItem(indecies[i].intValue(), Math.min(times[i]*currentHeats[i], this.maxHeat[i]));
	    }
	 }
	
	public void toastGroupedItems(int groupId, int currentHeat, int time) {
		// some king of timing function is needed here
		Integer[] indecies = groupingMap.get(groupId);
		System.out.println("Grouped, Toasting:");
		for(int i=0;i<indecies.length;i++) {
			engageItem(indecies[i].intValue(), currentHeat, items[i]);
			items[i].printState();
		}
		
	    for(int i=0;i<indecies.length;i++) {
			disengageItem(indecies[i].intValue(), Math.min(time*currentHeat, this.maxHeat[i]));
		}
	}
}
