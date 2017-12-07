package by.htp.rentStation.domain;

import java.util.List;

public class Catalog {

	private List<Unit> units;

	public Catalog() {
		super();
	}

	public Catalog(List<Unit> units) {
		super();
		this.units = units;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "Catalog [units=" + units + "]";
	}

}
