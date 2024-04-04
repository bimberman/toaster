
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlicedBread sb1 = new SlicedBread();
		SlicedBread sb2 = new SlicedBread();
		SlicedBread sb3 = new SlicedBread();
		Toaster t1 = new Toaster(3, 10);
		ToastableItem[] items = {sb1, sb2, sb3};
		Integer[] itemIndecies = new Integer[items.length];	
		int[] toastingTimes = new int[items.length];
		int[] currentHeats = new int[items.length];
		
		int max = 10;
        int min = 1;
        int range = max - min + 1;
		
		for(int i=0;i<items.length;i++) {
			itemIndecies[i] = i;
			int randTime = (int)(Math.random() * range) + min;
			int randHeat = (int)(Math.random() * range) + min;
			toastingTimes[i] = randTime;
			currentHeats[i] = randHeat;
		}

		System.out.println("Not Grouped, Not Toasted:");
		sb1.printState();
		sb2.printState();
		sb3.printState();
		t1.toastItems(toastingTimes, itemIndecies, currentHeats, items);
		System.out.println("Not Grouped, Toasted:");
		sb1.printState();
		sb2.printState();
		sb3.printState();
		
		
		SlicedBread sb4 = new SlicedBread();
		SlicedBread sb5 = new SlicedBread();
		SlicedBread sb6 = new SlicedBread();
		SlicedBread sb7 = new SlicedBread();
		Toaster t2 = new Toaster(4, 10);
		ToastableItem[] items2 = {sb4, sb5, sb6, sb7};
		Integer[] itemIndecies2 = new Integer[items2.length];	
		
		for(int i=0;i<items2.length;i++) {
			itemIndecies2[i] = i;
		}
		
		int groupId = t2.groupItems(itemIndecies2, items2);
		int toastingTime = 3;
		int currentHeat = 2;
		System.out.println("Grouped, Not Toasted:");
		sb4.printState();
		sb5.printState();
		sb6.printState();
		sb7.printState();
		t2.toastGroupedItems(groupId,currentHeat,toastingTime);
		System.out.println("Grouped, Toasted:");
		sb4.printState();
		sb5.printState();
		sb6.printState();
		sb7.printState();
	}

}
