package by.htp.rentStation.entity.accessory;

import by.htp.rentStation.entity.Category;

public class Helmet extends Accessory {

	public Helmet() {

	}

	public Helmet(int equipmentId, String title, Category category, String price, String size) {
		super(equipmentId, title, category, price, size);
	}

	@Override
	public String toString() {
		return "Helmet " + super.toString();
	}

	@Override
	public String toStringFile() {
		return "Helmet, " + getUnitId() + ", " + getTitle() + ", Category." + getCategory() + ", " + getPrice() + ", " + getSize();
	}
}
