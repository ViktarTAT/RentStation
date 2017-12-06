package by.htp.rentStation.comand.impl;

import by.htp.rentStation.comand.StationAction;
import by.htp.rentStation.entity.Order;
import by.htp.rentStation.entity.Unit;
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
