package by.htp.rentStation.controller.comand.impl;

import by.htp.rentStation.controller.comand.StationAction;
import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.dao.fileTxt.CatalogFileDAOImpl;
import by.htp.rentStation.dao.xml.dom.CatalogDAODOMImpl;
import by.htp.rentStation.dao.xml.sax.CatalogDAOSAXImpl;
import by.htp.rentStation.dao.xml.stax.CatalogDAOStAXImpl;
import by.htp.rentStation.domain.Catalog;
import by.htp.rentStation.domain.Unit;
import by.htp.rentStation.view.Print;

public class ViewCatalogActionIpml implements StationAction {
	private CatalogDAO dao;

	public ViewCatalogActionIpml() {
		//dao = new CatalogFileDAOImpl();
		//dao = new CatalogDAOSAXImpl();
		//dao = new CatalogDAODOMImpl();
		dao = new CatalogDAOStAXImpl();
	}

	@Override
	public void performAction() {
		Catalog units = dao.readCatalogUnit();
		Print.print("------");
		for (Unit unit : units.getUnits()) {
			Print.print(unit);
		}
		Print.print("------");
	}

}
