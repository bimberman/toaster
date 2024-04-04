
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
	public double getToastedAmountFromIntensity(int intensity) {
		// TODO Auto-generated method stub
		return (intensity-minToasting)/(maxToasting-minToasting);
	}

}
