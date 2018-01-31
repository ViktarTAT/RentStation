package by.htp.rentStation.service;

import by.htp.rentStation.domain.Catalog;
import by.htp.rentStation.domain.Unit;

public interface CatalogService {

	Catalog getCatalogUnit();
	
	Catalog getCatalogRentUnit();
	
	void writeCatalogUnit(Catalog catalog);

	void writeCatalogRentUnit(Catalog catalog);

	void writeUnitInCatalogUnit(Unit unit);

	void writeUnitInCatalogRentUnit(Unit unit);
}
