import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Toaster {
	ArrayList<ToastableItem> items = null;
	boolean isPoweredOn = false;
	ToasterSlot[] slots = null;
	int DEFAULT_NUMBER_OF_SLOTS = 2;
	
	HashMap<Integer, Integer[]> slotsGroupingMap = new HashMap<Integer, Integer[]>();
	HashMap<Integer, Integer> slotsToItemsMap = new HashMap<Integer, Integer>();
	
	public Toaster(int numOfSlots) {
		this.slots = new ToasterSlot[numOfSlots];
		this.items = new ArrayList<ToastableItem>();
		
		for(int i=0;i<this.slots.length; i++){
		   this.slots[i] =  new ToasterSlot();
		}
	}

	public Toaster(int numOfSlots, int maxHeat) {
		this.slots = new ToasterSlot[numOfSlots];
		this.items = new ArrayList<ToastableItem>();
		
		for(int i=0;i<this.slots.length; i++){
		   this.slots[i] =  new ToasterSlot(maxHeat);
		}
	}
	
	public Toaster(int numOfSlots, int maxHeat, int minHeat) {
		this.slots = new ToasterSlot[numOfSlots];
		this.items = new ArrayList<ToastableItem>();
		
		for(int i=0;i<this.slots.length; i++){
		   this.slots[i] =  new ToasterSlot(maxHeat, minHeat);
		}
	}
	
	public int groupSlots(Integer[] indecies) {
		int groupId = slotsGroupingMap.size();
		slotsGroupingMap.put(groupId, indecies);		
		return groupId;
	}
	
	public void insertItem(Integer slotIndex, ToastableItem item) {
		items.add(item);
		slotsToItemsMap.put(slotIndex, items.size());
	}
	
	public void insertItems(Integer[] slotIndecies, ToastableItem[] items) {
		for(int i=0;i<slotIndecies.length;i++) {
			insertItem(slotIndecies[i], items[i]);
		}
	}
	
	public void startToasting(int index, int time) {
		if(this.slots[index]==null) {
			throw new RuntimeException("There is no slot at this index");
		}

		ToasterSlot slot = this.slots[index];
		slot.setIsEnggaged(true);
		slot.setTime(time);
		
		Integer itemIndex = slotsToItemsMap.get(index);
		ToastableItem item = this.items.get(itemIndex);
		if(item!=null) {
			item.isToasting = true;
		}
	}
	
	
	public void stopToasting(int index) {
		if(this.slots[index]==null) {
			throw new RuntimeException("There is no slot at this index");
		}

		ToasterSlot slot = this.slots[index];
		slot.setIsEnggaged(false);
		slot.setTime(0);
		
		Integer itemIndex = slotsToItemsMap.get(index);
		ToastableItem item = this.items.get(itemIndex);
		if(item!=null) {
			item.isToasting = false;
			item.isToasted = true;
			item.toastedAmount = item.getToastedAmountFromIntensity(slot.getIntensity());
		}
	}
	

	public void startToastingGroupedItems(int groupId, int time) {
		// some king of timing function is needed here
		Integer[] indecies = slotsGroupingMap.get(groupId);
		System.out.println("Grouped, Toasting:");
		for(int i=0;i<indecies.length;i++) {
			startToasting(indecies[i].intValue(), time);
		}
	}
	
	public void stopToastingGroupedItems(int groupId, int time) {
		// some king of timing function is needed here
		Integer[] indecies = slotsGroupingMap.get(groupId);
		System.out.println("Grouped, Stop Toasting:");
		for(int i=0;i<indecies.length;i++) {
			stopToasting(indecies[i].intValue());
		}
	}
}
