package by.htp.rentStation.dao;

import java.util.List;
import by.htp.rentStation.entity.Unit;

public interface CatalogDAO {

	List<Unit> readCatalogUnit();
	
	List<Unit> readCatalogRentUnit();
	
	void writeCatalogUnit(List<Unit> catalog);

	void writeCatalogRentUnit(List<Unit> catalog);
	
	void writeUnitInCatalogUnit(Unit unit);

	void writeUnitInCatalogRentUnit(Unit unit);
	
}
