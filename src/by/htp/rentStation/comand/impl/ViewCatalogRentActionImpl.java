package by.htp.rentStation.comand.impl;

import by.htp.rentStation.comand.StationAction;
import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.dao.file.CatalogFileDAOImpl;
import by.htp.rentStation.entity.Catalog;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.util.Print;

public class ViewCatalogRentActionImpl implements StationAction {

	private CatalogDAO dao;

	public ViewCatalogRentActionImpl() {
		dao = new CatalogFileDAOImpl();
	}

	@Override
	public void performAction() {
		Catalog catalog = dao.readCatalogRentUnit();
		Print.print("------");
		for (Unit unit : catalog.getUnits()) {
			Print.print(unit);
		}
		Print.print("------");
	}

}
