package by.htp.rentStation.logic;

import java.math.BigDecimal;

import by.htp.rentStation.entity.Order;

public interface ReturnUnit {

	BigDecimal closseOrder(Order order);
}
