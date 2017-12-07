package by.htp.rentStation.dao;

import by.htp.rentStation.domain.Unit;

public interface UnitDAO {
	
	Unit searchUnitById(int unitId);

	void removeUnitCatalog(Unit unit);

}
