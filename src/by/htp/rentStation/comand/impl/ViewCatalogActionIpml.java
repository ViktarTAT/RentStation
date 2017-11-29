package by.htp.rentStation.comand.impl;

import by.htp.rentStation.comand.StationAction;
import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.dao.file.CatalogFileDAOImpl;
import by.htp.rentStation.dao.xml.CatalogDAOSAXImpl;
import by.htp.rentStation.entity.Catalog;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.util.Print;

public class ViewCatalogActionIpml implements StationAction {
	private CatalogDAO dao;

	public ViewCatalogActionIpml() {
		//dao = new CatalogFileDAOImpl();
		dao = new CatalogDAOSAXImpl();
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
