package by.htp.rentStation.domain;

public enum Category {
	WINTER, SUMMER;

	public static Category getCategory(String text) {
		return Category.valueOf(text.toUpperCase());
	}
}
