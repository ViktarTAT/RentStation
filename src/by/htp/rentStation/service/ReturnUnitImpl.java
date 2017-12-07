package by.htp.rentStation.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import by.htp.rentStation.domain.Order;
import by.htp.rentStation.domain.Unit;

public class ReturnUnitImpl implements ReturnUnit {
	
	public BigDecimal closseOrder(Order order){
		BigDecimal price;// = new BigDecimal("0");
		Calendar realTime = (GregorianCalendar) GregorianCalendar.getInstance();
		price = order.getTotalPriceHour().multiply(new BigDecimal(order.getTimeRent()));
		
		if(realTime.get(Calendar.HOUR) > order.getTimeReturnRent().get(Calendar.HOUR)){
			int fineTime = realTime.get(Calendar.HOUR) - order.getTimeReturnRent().get(Calendar.HOUR);
			BigDecimal temp = order.getTotalPriceHour().multiply(new BigDecimal(fineTime));
			price = price.multiply(temp);
		}
		return price;
	}
	
	private void moveUnit(Unit unit) {
		
	}
}
