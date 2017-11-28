package by.htp.rentStation.comand.impl;

import java.util.List;

import by.htp.rentStation.comand.StationAction;
import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.dao.file.CatalogFileDAOImpl;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.util.Print;

public class ViewCatalogRentActionImpl implements StationAction {

private CatalogDAO dao;
	
	public ViewCatalogRentActionImpl(){
		dao = new CatalogFileDAOImpl();
	}
	
	@Override
	public void performAction() {
		List<Unit> catalog = dao.readCatalogRentUnit();
		Print.print("------");
		for(Unit unit : catalog){
			Print.print(unit);
		}
		Print.print("------");
	}

}
