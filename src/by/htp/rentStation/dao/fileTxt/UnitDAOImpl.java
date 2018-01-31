package by.htp.rentStation.dao.fileTxt;

import java.util.List;

import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.dao.UnitDAO;
import by.htp.rentStation.domain.Catalog;
import by.htp.rentStation.domain.Unit;

public class UnitDAOImpl implements UnitDAO {
	private CatalogDAO dao;

	public UnitDAOImpl() {
		dao = new CatalogFileDAOImpl();
	}

	@Override
	public Unit searchUnitById(int unitId) {
		for (Unit unit : dao.getCatalogUnit().getUnits()) {
			if (unit.getUnitId() == unitId) {
				return unit;
			}
		}
		return null;
	}

	public void shiftUnitInRentCatalog(Unit unit) {
		if (unit != null) {
			Catalog catalog = dao.getCatalogUnit();
			dao.writeUnitInCatalogRentUnit(unit);
			catalog.getUnits().remove(unit);
			dao.writeCatalogUnit(catalog);
		}
	}

	@Override
	public void removeUnitCatalog(Unit unit) {
		Catalog catalog = dao.getCatalogUnit();
		catalog.getUnits().remove(unit);
		dao.writeCatalogUnit(catalog);
	}

}
