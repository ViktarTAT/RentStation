package by.htp.rentStation.controller.comand.impl;

import by.htp.rentStation.controller.comand.StationAction;
import by.htp.rentStation.service.impl.OrderLogicImpl;
import by.htp.rentStation.view.Menu;
import by.htp.rentStation.view.Print;

public class RentUnitActionImpl implements StationAction {

	@Override
	public void performAction() {
		Print.print("Enter id equipment");
		int unitId = Menu.readConsole();
		OrderLogicImpl logic = new OrderLogicImpl();
		logic.createOrder();
		logic.rentEquipment(unitId);

		do {
			logic.rentAccessory(unitId);
			Menu.printMenuOder();
		} while ((unitId = Menu.readConsole()) != 9);
		Print.print("Enter rental time");
		//Print.print(logic.takeOrder(Menu.readConsole()));
	}
}
