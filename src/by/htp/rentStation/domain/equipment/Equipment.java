package by.htp.rentStation.domain.equipment;

import by.htp.rentStation.domain.Category;
import by.htp.rentStation.domain.Unit;

public abstract class Equipment extends Unit {
	private Gender gender;

	public Equipment() {

	}

	public Equipment(int equipmentId, String title, Category category, String price, Gender gender) {
		super(equipmentId, title, category, price);
		this.gender = gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Gender getGender() {
		return gender;
	}

	// TODO del
	public int incrementCounter(int counter) {
		counter++;
		return counter;
	}

	// TODO del
	public int decreaseCounter(int counter) {
		counter--;
		return counter;
	}

	@Override
	public String toString() {
		return super.toString() + ", gender=" + gender;
	}
	
	
}
