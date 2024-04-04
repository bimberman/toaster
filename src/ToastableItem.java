
public abstract class ToastableItem {
	boolean isToasted = false;
	boolean isToasting = false;
	double toastedAmount = 0;
	int width = 0;
	int height = 0;
	
	public void printState() {
		System.out.println("isToasted: " + isToasted + ", isToasting:" + isToasting + ", toastedAmount:" + toastedAmount);
	}
	
	public void printState(String s) {
		System.out.println(s + ": isToasted: " + isToasted + ", isToasting:" + isToasting + ", toastedAmount:" + toastedAmount);
	}
	
	public abstract double getToastedAmountFromIntensity(int intensity);
}
