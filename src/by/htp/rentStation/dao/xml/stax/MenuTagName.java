package by.htp.rentStation.dao.xml.stax;

public enum MenuTagName {
    BIKE, ROLLER, HELMET, PROTECT, PRICE, TITLE, CATEGORY, SIZE, GENDER, GROWTH;

    public static MenuTagName getElementTagName(String element) {
	switch (element) {
	case "bike":
	    return BIKE;
	case "roller":
	    return ROLLER;
	case "helmet":
	    return HELMET;
	case "protect":
	    return PROTECT;
	case "price":
	    return PRICE;
	case "title":
	    return TITLE;
	case "category":
	    return CATEGORY;
	case "size":
	    return SIZE;
	case "growth":
	    return GROWTH;
	default:
	    throw new EnumConstantNotPresentException(MenuTagName.class, element);
	}
    }

}
