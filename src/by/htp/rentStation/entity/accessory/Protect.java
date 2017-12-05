package by.htp.rentStation.entity.accessory;

import by.htp.rentStation.entity.Category;

public class Protect extends Accessory {
	private int growth;

	public Protect() {

	}

	public Protect(int equipmentId, String title, Category category, String price, String size, int growth) {
		super(equipmentId, title, category, price, size);
		this.growth = growth;
	}

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
	}

	@Override
	public String toString() {
		return "Protect "+ super.toString() + ", growth=" + growth;
	}

	
}
