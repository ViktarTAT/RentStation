package by.htp.rentStation.controller.comand.impl;

import by.htp.rentStation.controller.comand.StationAction;
import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.dao.fileTxt.CatalogFileDAOImpl;
import by.htp.rentStation.dao.xml.stax.CatalogDAOStAXImpl;
import by.htp.rentStation.domain.Catalog;
import by.htp.rentStation.domain.Unit;
import by.htp.rentStation.view.Print;

public class ViewCatalogRentActionImpl implements StationAction {

    private CatalogDAO dao;

    public ViewCatalogRentActionImpl() {
	// dao = new CatalogFileDAOImpl();
	dao = new CatalogDAOStAXImpl();
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
