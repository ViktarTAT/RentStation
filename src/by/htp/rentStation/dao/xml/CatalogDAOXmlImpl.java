package by.htp.rentStation.dao.xml;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.entity.Catalog;
import by.htp.rentStation.entity.Unit;


public class CatalogDAOXmlImpl implements CatalogDAO {
	private static final String XML_FILE_PATH = "source/unit.xml";

	@Override
	public Catalog readCatalogUnit() {
		return readCatalog(XML_FILE_PATH);
	}

	@Override
	public Catalog readCatalogRentUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Catalog readCatalog(String filePath) {
		Catalog catalog = new Catalog();

		try {
			CatalogDataHandler handler = new CatalogDataHandler();
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
			reader.parse(filePath);
			List<Unit> units = handler.getList();
			catalog.setUnits(units);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		return catalog;
	}

	@Override
	public void writeCatalogUnit(Catalog catalog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeCatalogRentUnit(Catalog catalog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeUnitInCatalogUnit(Unit unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeUnitInCatalogRentUnit(Unit unit) {
		// TODO Auto-generated method stub

	}

}
