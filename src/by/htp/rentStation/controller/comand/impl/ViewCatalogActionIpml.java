package by.htp.rentStation.controller.comand.impl;

import by.htp.rentStation.controller.comand.StationAction;
import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.dao.fileTxt.CatalogFileDAOImpl;
import by.htp.rentStation.dao.xml.dom.CatalogDAODOMImpl;
import by.htp.rentStation.dao.xml.sax.CatalogDAOSAXImpl;
import by.htp.rentStation.dao.xml.stax.CatalogDAOStAXImpl;
import by.htp.rentStation.domain.Catalog;
import by.htp.rentStation.domain.Unit;
import by.htp.rentStation.service.CatalogService;
import by.htp.rentStation.service.impl.CatalogServiceImpl;
import by.htp.rentStation.view.Print;

public class ViewCatalogActionIpml implements StationAction {

	@Override
	public void performAction() {
		CatalogService catalogService = new CatalogServiceImpl();
		Catalog units = catalogService.getCatalogUnit();
		Print.print("------");
		for (Unit unit : units.getUnits()) {
			Print.print(unit);
		}
		Print.print("------");
	}

}
