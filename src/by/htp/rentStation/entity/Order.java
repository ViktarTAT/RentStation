package by.htp.rentStation.entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Order {
	private static int orderCount;

	private int orderId;
	private RentUnit rentUnit;
	private BigDecimal totalPriceHour;
	private int timeRent;
	private Calendar timeReturnRent;

	public Order() {
		rentUnit = new RentUnit();
		totalPriceHour = new BigDecimal(0);
		orderCount++;
		orderId = orderCount;
	}

	public int getOrderId() {
		return orderId;
	}

	public RentUnit getRentUnit() {
		return rentUnit;
	}

	public BigDecimal getTotalPrice() {
		return totalPriceHour;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPriceHour = totalPrice;
	}

	public Calendar getTimeReturnRent() {
		return timeReturnRent;
	}

	public void setTimeReturnRent(Calendar timeReturnRent) {
		this.timeReturnRent = timeReturnRent;
	}
	
	public int getTimeRent() {
		return timeRent;
	}

	public void setTimeRent(int timeRent) {
		this.timeRent = timeRent;
	}
	
}
