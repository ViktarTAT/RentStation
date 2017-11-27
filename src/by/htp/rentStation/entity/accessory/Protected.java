package by.htp.rentStation.entity.accessory;

import by.htp.rentStation.entity.Category;

public class Protected extends Accessory {
	private int growth;

	public Protected(int equipmentId, String title, Category category, String price, String size, int growth) {
		super(equipmentId, title, category, price, size);
		this.growth = growth;
	}

	public int getGrowth() {
		return growth;
	}

	@Override
	public String toStringFile() {
		return "Helmet, " + getUnitId() + ", " + getTitle() + ", Category." + getCategory() + ", " + getPrice() + ", "
				+ getSize() + ", " + growth;
	}

}
