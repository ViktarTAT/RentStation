package by.htp.rentStation.service;

import by.htp.rentStation.dao.UnitDAO;
import by.htp.rentStation.dao.fileTxt.UnitDAOImpl;
import by.htp.rentStation.domain.Order;
import by.htp.rentStation.domain.OrderList;
import by.htp.rentStation.domain.Unit;
import by.htp.rentStation.domain.accessory.Accessory;
import by.htp.rentStation.domain.equipment.Equipment;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrderLogicImpl implements OrderLogic {
    private Order order;
    private UnitDAO udao; 
    private OrderList orderList;
    
    @Override
    public void createOrder() {
	order = new Order();	
    }
    
    @Override
    public void rentEquipment(int id) {
	Unit unit = udao.searchUnitById(id);
	Equipment equipment = (Equipment) unit;
	order.setEquipment(equipment);
	appendPrice(equipment.getPrice());
    }

    public void rentAccessory(int id) {
	Unit unit = udao.searchUnitById(id);
	Accessory accessory = (Accessory) unit;
	order.getAccessories().add(accessory);
	appendPrice(accessory.getPrice());
    }

    private void appendPrice(BigDecimal price) {
	BigDecimal totalPrice = order.getTotalPriceHour();
	totalPrice = totalPrice.add(price);
	order.setTotalPriceHour(totalPrice);
    }

    public void takeOrder(int hour) {
	if (hour > 0) { // TODO iskl
	    order.setTimeRent(hour);
	    order.setTimeReturnRent(GregorianCalendar.getInstance());
	    order.getTimeReturnRent().add(Calendar.HOUR, hour);
	    orderList.getOrders().add(order);
	    shiftUnitsCatalog();
	}
    }

    private void shiftUnitsCatalog() {
	udao.removeUnitCatalog(order.getEquipment());
	for (Unit unit : order.getAccessories()) {
	    udao.removeUnitCatalog(unit);
	}

    }

   
}
