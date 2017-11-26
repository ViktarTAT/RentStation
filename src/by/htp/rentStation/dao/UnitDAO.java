package by.htp.rentStation.dao;

import by.htp.rentStation.entity.Unit;

public interface UnitDAO {
	
	Unit searchUnitById(int unitId);

	void removeUnitCatalog(Unit unit);

}
