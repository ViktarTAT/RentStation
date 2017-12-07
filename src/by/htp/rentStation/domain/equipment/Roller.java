package by.htp.rentStation.domain.equipment;

import by.htp.rentStation.domain.Category;

public class Roller extends Equipment {
	private int size;

	public Roller() {
		super();
	}

	public Roller(int equipmentId, String title, Category category, String price, Gender gender, int size) {
		super(equipmentId, title, category, price, gender);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Roller " + super.toString() + ", size=" + size;
	}

}
