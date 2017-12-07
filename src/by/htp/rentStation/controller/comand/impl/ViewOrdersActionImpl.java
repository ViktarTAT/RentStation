package by.htp.rentStation.controller.comand.impl;

import java.util.Formatter;
import java.util.List;

import by.htp.rentStation.controller.comand.StationAction;
import by.htp.rentStation.domain.Order;
import by.htp.rentStation.view.Print;

public class ViewOrdersActionImpl implements StationAction {
	private List<Order> orders;

	public ViewOrdersActionImpl(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public void performAction() {
		Formatter f;
		for (Order i : orders) {
			f = new Formatter();
			if (i != null) {

				Print.print("-----------");
				f.format("%tl:%tM", i.getTimeReturnRent(), i.getTimeReturnRent());
				Print.print("time return: " + f);
				Print.print("total price per hour: " + i.getTotalPrice());
			}
		}
	}

}
