package by.htp.rentStation.entity;

public enum Category {
	WINTER, SUMMER;

	public static Category createCategory(String text) {
		return Category.valueOf(text.toUpperCase());
	}
}
