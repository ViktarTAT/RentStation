package by.htp.rentStation.entity.equipment;

import by.htp.rentStation.entity.Category;

public class Bike extends Equipment {

	public Bike() {

	}

	public Bike(int equipmentId, String title, Category category, String price) {
		super(equipmentId, title, category, price);
	}

	@Override
	public String toString() {
		return "Bike " + super.toString();
	}

	@Override
	public String toStringFile() {
		return "Bike, " + getUnitId() + ", " + getTitle() + ", Category." + getCategory() + ", " + getPrice();
	}

}
