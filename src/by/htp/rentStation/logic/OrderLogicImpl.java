package by.htp.rentStation.logic;

import by.htp.rentStation.dao.UnitDAO;
import by.htp.rentStation.dao.file.UnitDAOImpl;
import by.htp.rentStation.entity.Order;
import by.htp.rentStation.entity.RentUnit;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.entity.accessory.Accessory;
import by.htp.rentStation.entity.equipment.Equipment;

import static by.htp.rentStation.util.Constant.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class OrderLogicImpl implements OrderLogic {
    private Order order;
    private UnitDAO udao = new UnitDAOImpl();

    

    @Override
    public void rentEquipment(int id) {
	order = new Order();
	Unit unit = udao.searchUnitById(id);
	Equipment equipment = (Equipment) unit;
	order.setEquipment(equipment);
    }

    public void rentAccessory(int id){
	Unit unit = udao.searchUnitById(id);
	Accessory accessory = (Accessory) unit;
	order.getAccessories().add(accessory);
    }
    
    private void appendPrice(BigDecimal price){
	BigDecimal totalPrice = order.getTotalPriceHour();
	totalPrice = totalPrice.
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
	for (Unit unit : units) {
	    udao.removeUnitCatalog(unit);
	}

    }
}
