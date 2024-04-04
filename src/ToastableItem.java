
public class ToastableItem {
	boolean isToasted = false;
	boolean isToasting = false;
	int toastedAmount = 0;
	int width = 0;
	int height = 0;
	
	ToastableItem(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void printState() {
		System.out.println("isToasted: " + isToasted + ", isToasting:" + isToasting + ", toastedAmount:" + toastedAmount);
	}
	
	public void printState(String s) {
		System.out.println(s + ": isToasted: " + isToasted + ", isToasting:" + isToasting + ", toastedAmount:" + toastedAmount);
	}
}
