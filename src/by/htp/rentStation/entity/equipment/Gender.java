package by.htp.rentStation.entity.equipment;

public enum Gender {
	MALE, FEMALE;
	
	public static Gender createGender(String text){
		return Gender.valueOf(text.toUpperCase());
	}
}
