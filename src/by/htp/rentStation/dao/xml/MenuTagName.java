package by.htp.rentStation.dao.xml;

public enum MenuTagName {
    BIKE, ROLLER, HELMET, PROTECT, PRICE, TITLE, CATEGORY, SIZE, GENDER, GROWTH, ID, COLOR, UNITS;

    public static MenuTagName getTagName(String tag) {
	MenuTagName tag2 = null;
	try{
	tag2 = MenuTagName.valueOf(tag.toUpperCase());
	}catch(IllegalArgumentException e){
	    System.out.println(tag);
	    e.printStackTrace();
	}
	return tag2;
	
    }
}
