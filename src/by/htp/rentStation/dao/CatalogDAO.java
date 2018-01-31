package by.htp.rentStation.dao;

import by.htp.rentStation.domain.Catalog;
import by.htp.rentStation.domain.Unit;

public interface CatalogDAO {

	Catalog getCatalogUnit();

	Catalog getCatalogRentUnit();

	void writeCatalogUnit(Catalog catalog);

	void writeCatalogRentUnit(Catalog catalog);

	void writeUnitInCatalogUnit(Unit unit);

	void writeUnitInCatalogRentUnit(Unit unit);

}
