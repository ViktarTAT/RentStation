package by.htp.rentStation.domain.equipment;

public enum Gender {
	MALE, FEMALE;
	
	public static Gender getGender(String text){
		return Gender.valueOf(text.toUpperCase());
	}
}
