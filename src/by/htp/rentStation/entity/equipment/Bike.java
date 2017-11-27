package by.htp.rentStation.entity.equipment;

import by.htp.rentStation.entity.Category;

public class Bike extends Equipment {
	private int growth;

	public Bike() {

	}

	public Bike(int equipmentId, String title, Category category, String price, Gender gender, int growh) {
		super(equipmentId, title, category, price, gender);
		this.growth = growh;
	}

	public int getGrowh() {
		return growth;
	}

	@Override
	public String toString() {
		return "Bike " + super.toString();
	}

	@Override
	public String toStringFile() {
		return "Bike, " + getUnitId() + ", " + getTitle() + ", Category." + getCategory() + ", " + getPrice() + ", "
				+ getGender() + ", " + growth;
	}

}
