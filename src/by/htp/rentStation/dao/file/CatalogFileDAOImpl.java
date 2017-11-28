package by.htp.rentStation.dao.file;

import java.util.ArrayList;
import java.util.List;

import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.entity.Unit;

public class CatalogFileDAOImpl implements CatalogDAO {
	private static final String FILE_PATH = "C:\\Users\\VIKTAR\\eclipse-workspace\\RentStation\\source\\unit.txt";
	private static final String FILE_RENT_PATH = "C:\\Users\\VIKTAR\\eclipse-workspace\\RentStation\\source\\unitRent.txt";
	private static final String DELIMETER = ",";

	@Override
	public List<Unit> readCatalogUnit() {
		return readCatalog(FILE_PATH);
	}

	@Override
	public List<Unit> readCatalogRentUnit() {
		return readCatalog(FILE_RENT_PATH);
	}

	private List<Unit> readCatalog(String filePath) {
		List<Unit> catalog = new ArrayList<>();
		List<String> lines = ReaderFile.readerList(filePath);

		for (String line : lines) {
			if (line != null) {
				catalog.add(FactoryRentUnit.createUnit(line, DELIMETER));
			}
		}
		return catalog;
	}

	public void writeCatalogUnit(List<Unit> catalog) {
		writeCatalog(catalog, FILE_PATH);
	}

	public void writeCatalogRentUnit(List<Unit> catalog) {
		writeCatalog(catalog, FILE_RENT_PATH);
	}

	private void writeCatalog(List<Unit> catalog, String filePath) {

		List<String> lines = new ArrayList<String>();

		for (Unit unit : catalog) {
			if (unit != null) {
				lines.add(unit.toStringFile());
			}
		}
		WriterFile.writeCatalog(filePath, lines);
	}

	@Override
	public void writeUnitInCatalogUnit(Unit unit) {
		WriterFile.writeLine(FILE_PATH, unit.toStringFile());
		
	}

	@Override
	public void writeUnitInCatalogRentUnit(Unit unit) {
		WriterFile.writeLine(FILE_RENT_PATH, unit.toStringFile());
		
	}

}
