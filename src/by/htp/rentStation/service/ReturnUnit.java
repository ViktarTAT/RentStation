package by.htp.rentStation.service;

import java.math.BigDecimal;

import by.htp.rentStation.domain.Order;

public interface ReturnUnit {

	BigDecimal closseOrder(Order order);
}
