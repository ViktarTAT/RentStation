package by.htp.rentStation.entity.equipment;

import by.htp.rentStation.entity.Category;

public class Roller extends Equipment {
	private int size;
	
	public Roller(int equipmentId, String title, Category category, String price, Gender gender, int size) {
		super(equipmentId, title, category, price, gender);
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	@Override
	public String toStringFile() {
		return "Roller, " + getUnitId() + ", " + getTitle() + ", Category." + getCategory() + ", " + getPrice() +
				", " + getGender() + ", " + size;
	}

}
