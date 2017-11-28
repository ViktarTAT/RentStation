package by.htp.rentStation.dao;

import by.htp.rentStation.entity.Catalog;
import by.htp.rentStation.entity.Unit;

public interface CatalogDAO {

	Catalog readCatalogUnit();

	Catalog readCatalogRentUnit();

	void writeCatalogUnit(Catalog catalog);

	void writeCatalogRentUnit(Catalog catalog);

	void writeUnitInCatalogUnit(Unit unit);

	void writeUnitInCatalogRentUnit(Unit unit);

}
