import java.util.Random;

public class Box {

	int value = 0;
	
	void initialize() {
		int a = new Random().nextInt(50);
		if(a > 40) {
			value = 4;
		} else {
			value = 2;
		}
	}
	
	int getValue() {
		return value;
	}
	
	void increaseValue() {
		System.out.println(value);
		value *= 2;
		System.out.println(value);
	}
	
}
