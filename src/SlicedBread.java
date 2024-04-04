
public class SlicedBread extends ToastableItem{
	
	int minToasting = 0;
	int maxToasting = 10;
	
	SlicedBread() {
		// TODO Auto-generated constructor stub
	}
	
	SlicedBread(int width, int height) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getToastedAmountFromIntensity(double intensity) {
		// TODO Auto-generated method stub
		return (intensity-minToasting)/(maxToasting-minToasting)*100;
	}
	
	@Override
	public String toString() {
		return "isToasting: " + this.isToasting +  ", isToasted: " + this.isToasted +  ", toastedAmount: " + this.toastedAmount + "%";
	}

}
