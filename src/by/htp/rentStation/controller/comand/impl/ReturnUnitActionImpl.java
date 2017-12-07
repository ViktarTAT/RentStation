package by.htp.rentStation.controller.comand.impl;

import by.htp.rentStation.controller.comand.StationAction;
import by.htp.rentStation.domain.Order;
import by.htp.rentStation.domain.Unit;
import by.htp.rentStation.view.Menu;
import by.htp.rentStation.view.Print;

public class ReturnUnitActionImpl implements StationAction {
	
	@Override
	public void performAction() {
		Print.print("Enter id unit");
		int orderId = Menu.readConsole();
		//Order order = station.searchOrderById(orderId);
		
	}

}
