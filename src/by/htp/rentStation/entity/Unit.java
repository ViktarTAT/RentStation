package by.htp.rentStation.entity;

import java.math.BigDecimal;

public abstract class Unit implements Comparable<Unit> {// TODO serializable,

	private int unitId;
	private String title;
	private Category category;
	private BigDecimal price;

	public Unit() {

	}

	public Unit(int equipmentId, String title, Category category, String price) {
		super();
		this.unitId = equipmentId;
		this.title = title;
		this.category = category;
		this.price = new BigDecimal(price);
	}

	public int getUnitId() {
		return unitId;
	}

	public String getTitle() {
		return title;
	}

	public Category getCategory() {
		return category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public abstract int incrementCounter(int counter);

	public abstract int decreaseCounter(int counter);

	@Override
	public String toString() {
		return " Id=" + unitId + ", title=" + title + ", category=" + category + ", price=" + price;
	}

	public abstract String toStringFile();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + unitId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		if (category != other.category)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (unitId != other.unitId)
			return false;
		return true;
	}

	@Override
	public int compareTo(Unit o) {
		return this.unitId - o.unitId;
	}

}
