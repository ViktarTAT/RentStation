package by.htp.rentStation.comand.impl;

import by.htp.rentStation.comand.StationAction;
import by.htp.rentStation.logic.OrderLogicImpl;
import by.htp.rentStation.view.Menu;
import by.htp.rentStation.view.Print;

public class RentUnitActionImpl implements StationAction {

	@Override
	public void performAction() {
		Print.print("Enter id unit");
		int unitId = Menu.readConsole();
		OrderLogicImpl logic = new OrderLogicImpl();
		logic.createOrder();

		do {
			logic.rentUnit(unitId);
			Menu.printMenuOder();
		} while ((unitId = Menu.readConsole()) != 9);
		Print.print("Enter rental time");
		Print.print(logic.takeOrder(Menu.readConsole()));
	}
}
