package by.htp.rentStation.dao.xml;

public enum MenuTagName {
    BIKE, ROLLER, HELMET, PROTECT, PRICE, TITLE, CATEGORY, SIZE, GENDER, GROWTH, ID, COLOR, UNITS;

    public static MenuTagName getTagName(String tag) {
	return MenuTagName.valueOf(tag.toUpperCase());	
    }
    
    public static String getStringTagName(MenuTagName tag) {
	return tag.toString().toLowerCase();
    }
}
