package by.htp.rentStation.comand.impl;

import java.util.List;

import by.htp.rentStation.comand.StationAction;
import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.dao.CatalogFileDAOImpl;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.util.Print;

public class ViewCatalogActionIpml implements StationAction {
	private CatalogDAO dao;
	
	public ViewCatalogActionIpml(){
		dao = new CatalogFileDAOImpl();
	}
	
	@Override
	public void performAction() {
		List<Unit> units = dao.readCatalogUnit();
		Print.print("------");
		for(Unit unit : units){
			Print.print(unit);
		}
		Print.print("------");
	}

}
