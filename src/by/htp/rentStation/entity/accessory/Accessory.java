package by.htp.rentStation.entity.accessory;

import by.htp.rentStation.entity.Category;
import by.htp.rentStation.entity.Unit;

public abstract class Accessory extends Unit {
	private String size;
	
	public Accessory() {

	}

	public Accessory(int equipmentId, String title, Category category, String price, String size) {
		super(equipmentId, title, category, price);
		this.size = size;
	}
	
	public String getSize() {
		return size;
	}

	//TODO del
	public int incrementCounter(int counter) {
		return counter;
	}

	//TODO del
	public int decreaseCounter(int counter) {
		return counter;
	}

}
