package by.htp.rentStation.entity.equipment;

public enum Gender {
	MALE, FEMALE;
	
	public static Gender getGender(String text){
	    System.out.println(MALE.toString().toLowerCase());
		return Gender.valueOf(text.toUpperCase());
	}
}
