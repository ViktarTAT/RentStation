package by.htp.rentStation.entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import by.htp.rentStation.entity.accessory.Accessory;
import by.htp.rentStation.entity.equipment.Equipment;

public class Order {
	

	private int id;
	private Equipment equipment;
	private List<Accessory> accessories;
	private BigDecimal totalPriceHour;
	private int timeRent;
	private Calendar timeReturnRent;

	public Order() {
		totalPriceHour = new BigDecimal(0);
	}

	public int getId() {
		return id;
	}

	public Equipment getEquipment() {
	    return equipment;
	}

	public void setEquipment(Equipment equipment) {
	    this.equipment = equipment;
	}

	public List<Accessory> getAccessories() {
	    return accessories;
	}

	public void setAccessories(List<Accessory> accessories) {
	    this.accessories = accessories;
	}

	public BigDecimal getTotalPriceHour() {
	    return totalPriceHour;
	}

	public void setTotalPriceHour(BigDecimal totalPriceHour) {
	    this.totalPriceHour = totalPriceHour;
	}

	public int getTimeRent() {
	    return timeRent;
	}

	public void setTimeRent(int timeRent) {
	    this.timeRent = timeRent;
	}

	public Calendar getTimeReturnRent() {
	    return timeReturnRent;
	}

	public void setTimeReturnRent(Calendar timeReturnRent) {
	    this.timeReturnRent = timeReturnRent;
	}

	public void setId(int id) {
	    this.id = id;
	}
	
	
	
}
