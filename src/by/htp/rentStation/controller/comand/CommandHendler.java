package by.htp.rentStation.controller.comand;

import by.htp.rentStation.controller.comand.impl.DefoultActionImpl;
import by.htp.rentStation.controller.comand.impl.RentUnitActionImpl;
import by.htp.rentStation.controller.comand.impl.ViewCatalogActionIpml;
import by.htp.rentStation.controller.comand.impl.ViewCatalogRentActionImpl;
import by.htp.rentStation.controller.comand.impl.ViewOrdersActionImpl;


public class CommandHendler {
	

	public StationAction defineAction(int input) {
		StationAction action = new DefoultActionImpl();

		switch (input) {
		case 1:
			action = new ViewCatalogActionIpml();
			break;
		case 2:
			action = new ViewCatalogRentActionImpl();
			break;	
		case 3:
			action = new RentUnitActionImpl();
			break;
		case 4:
			//action = new ViewOrdersActionImpl();
			break;
		case 9:
			System.exit(0);
			break;	
		}
		return action;
	}
}
