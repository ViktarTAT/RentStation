package by.htp.rentStation.dao.xml.stax;

public enum MenuTagName {
    BIKE, ROLLER, HELMET, PROTECT, PRICE, TITLE, CATEGORY, SIZE, GENDER, GROWTH, ID, COLOR;

    public static MenuTagName getElementTagName(String tag) {
	return MenuTagName.valueOf(tag.toUpperCase());
    }
}
