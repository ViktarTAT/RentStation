package by.htp.rentStation.domain.equipment;

import by.htp.rentStation.domain.Category;

public class Bike extends Equipment {
	private int growth;

	public Bike() {

	}

	public Bike(int equipmentId, String title, Category category, String price, Gender gender, int growht) {
		super(equipmentId, title, category, price, gender);
		this.growth = growht;
	}

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
	}

	@Override
	public String toString() {
		return "Bike " + super.toString() + ", growth=" + growth;
	}

}
