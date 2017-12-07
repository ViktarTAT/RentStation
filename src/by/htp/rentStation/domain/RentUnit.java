package by.htp.rentStation.domain;

import java.util.ArrayList;
import java.util.List;

public class RentUnit {
	private List<Unit> units;
	private int countEquipment;
	// TODO make class counter????

	public RentUnit() {
		units = new ArrayList<>();
	}

	public int getCountEquipment() {
		return countEquipment;
	}

	public List<Unit> getUnits() {
		ArrayList<Unit> temp = (ArrayList<Unit>) units;
		temp.trimToSize();
		return temp;
	}

}
