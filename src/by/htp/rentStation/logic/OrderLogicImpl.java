package by.htp.rentStation.logic;

import by.htp.rentStation.dao.UnitDAO;
import by.htp.rentStation.dao.file.UnitDAOImpl;
import by.htp.rentStation.entity.Order;
import by.htp.rentStation.entity.RentUnit;
import by.htp.rentStation.entity.Unit;
import static by.htp.rentStation.util.Constant.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class OrderLogicImpl implements OrderLogic {
	private Order order;
	private UnitDAO udao = new UnitDAOImpl();

	public void createOrder() {
		order = new Order();
	}

	@Override
	public void rentUnit(int unitId) {
		Unit unit = udao.searchUnitById(unitId);
		addUnitOrder(unit);
		// udao.removeUnitCatalog(unit);
	}

	private boolean addUnitOrder(Unit unit) {
		if (addUnitInRentUnit(unit, order.getRentUnit())) {
			order.setTotalPrice(order.getTotalPrice().add(unit.getPrice()));
			return true;
		}
		return false;
	}

	private static boolean addUnitInRentUnit(Unit unit, RentUnit rentUnit) {
		if (unit != null) {
			int countEquipment = rentUnit.getCountEquipment();
			countEquipment = unit.incrementCounter(countEquipment);
			if (countEquipment <= MAX_EQUIPMENT_COUNT) {
				rentUnit.getUnits().add(unit);
				return true;
			}
		}
		return false;
	}
	
	public String takeOrder(int hour) {
		if (hour > 0) { //
			order.setTimeRent(hour);
			order.setTimeReturnRent(GregorianCalendar.getInstance());
			order.getTimeReturnRent().add(Calendar.HOUR, hour);
			shiftUnitsCatalog(order.getRentUnit().getUnits());
		}
		return "order id = " + order.getOrderId();
	}

	private void shiftUnitsCatalog(List<Unit> units) {
		for(Unit unit : units){
			udao.removeUnitCatalog(unit);
		}
		
	}
}
