import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Making items
		ArrayList<SlicedBread> items = new ArrayList<SlicedBread>();
		for(int i=0;i<10;i++) {
			items.add(new SlicedBread());
		}
		
		// Toaster 1 setup
		Toaster t1 = new Toaster("toaster1", 2);
		int[] itemIndeciesForToaster1 = {0,4};
		int[] slotIndeciesForToaster1 = {0,1};
		SlicedBread[] t1Items = new SlicedBread[itemIndeciesForToaster1.length];
		for(int i=0, j=0;i<items.size() && j<t1Items.length;i++) {
			t1Items[j] = items.get(itemIndeciesForToaster1[i]);
			j++;
		}
		
		// Toaster 2 setup
		Toaster t2 = new Toaster("toaster2", 5);
		int[] itemIndeciesForToaster2 = {1,2,7,8};
		int[] slotIndeciesForToaster2 = {0,2,3,4};
		SlicedBread[] t2Items = new SlicedBread[itemIndeciesForToaster2.length];
		for(int i=0, j=0;i<items.size() && j<t2Items.length;i++) {
			t2Items[j] = items.get(itemIndeciesForToaster2[i]);
			j++;
		}

		// Operations
		t1.insertItems(slotIndeciesForToaster1, t1Items);
		t1.startToasting(1, 3, 2);
		System.out.println(items.get(4).toString());
		t1.stopToasting(1);
		System.out.println(items.get(4).toString() + "\n");

		t2.insertItems(slotIndeciesForToaster2, t2Items);
		t2.startToasting(3, 5, 4);
		System.out.println(items.get(7).toString());
		t2.stopToasting(3);
		System.out.println(items.get(7).toString() + "\n");

		// Logging
		for(int i=0;i<10;i++) {
			System.out.println(items.get(i).toString());
		}
	}

}
