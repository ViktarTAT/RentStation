package by.htp.rentStation.dao;

import java.util.ArrayList;
import java.util.List;


import by.htp.rentStation.entity.Unit;

public class UnitDAOImpl implements UnitDAO {
	CatalogDAO dao = new CatalogFileDAOImpl();
	List<Unit> catalog = new ArrayList<>();

	@Override
	public Unit searchUnitById(int unitId) {
		for (Unit unit : dao.readCatalogUnit()) {
			if (unit.getUnitId() == unitId) {
				return unit;
			}
		}
		return null;
	}

	public void shiftUnitInRentCatalog(Unit unit) {
		if (unit != null) {
			List<Unit> catalog = dao.readCatalogUnit();
			dao.writeUnitInCatalogRentUnit(unit);
			catalog.remove(unit);
			dao.writeCatalogUnit(catalog);
		}
	}

	@Override
	public void removeUnitCatalog(Unit unit) {
		List<Unit> catalog = dao.readCatalogUnit();
		catalog.remove(unit);
		dao.writeCatalogUnit(catalog);
	}

}
