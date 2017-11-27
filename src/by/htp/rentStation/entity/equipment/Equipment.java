package by.htp.rentStation.entity.equipment;

import by.htp.rentStation.entity.Category;
import by.htp.rentStation.entity.Unit;

public abstract class Equipment extends Unit {
	private Enum sex;

	public Equipment() {
		
	}

	public Equipment(int equipmentId, String title, Category category, String price) {
		super(equipmentId, title, category, price);
	}

	public int incrementCounter(int counter) {
		counter++;
		return counter;
	}

	public int decreaseCounter(int counter) {
		counter--;
		return counter;
	}
}
