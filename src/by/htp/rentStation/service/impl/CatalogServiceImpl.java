package by.htp.rentStation.service.impl;

import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.dao.fileTxt.CatalogFileDAOImpl;
import by.htp.rentStation.domain.Catalog;
import by.htp.rentStation.domain.Unit;
import by.htp.rentStation.service.CatalogService;

public class CatalogServiceImpl implements CatalogService {

	@Override
	public Catalog getCatalogUnit() {
		CatalogDAO catalogDAO = new CatalogFileDAOImpl(); 
		return catalogDAO.getCatalogUnit();
	}

	@Override
	public Catalog getCatalogRentUnit() {
		CatalogDAO catalogDAO = new CatalogFileDAOImpl(); 
		return catalogDAO.getCatalogRentUnit();
	}

	@Override
	public void writeCatalogUnit(Catalog catalog) {
		CatalogDAO catalogDAO = new CatalogFileDAOImpl(); 
		catalogDAO.writeCatalogUnit(catalog);
	}

	@Override
	public void writeCatalogRentUnit(Catalog catalog) {
		CatalogDAO catalogDAO = new CatalogFileDAOImpl(); 
		catalogDAO.writeCatalogRentUnit(catalog);

	}

	@Override
	public void writeUnitInCatalogUnit(Unit unit) {
		CatalogDAO catalogDAO = new CatalogFileDAOImpl();
		catalogDAO.writeUnitInCatalogUnit(unit);
	}

	@Override
	public void writeUnitInCatalogRentUnit(Unit unit) {
		CatalogDAO catalogDAO = new CatalogFileDAOImpl();
		catalogDAO.writeUnitInCatalogRentUnit(unit);

	}

}
