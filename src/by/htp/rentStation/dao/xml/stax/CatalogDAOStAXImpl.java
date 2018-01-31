package by.htp.rentStation.dao.xml.stax;

import static by.htp.rentStation.util.Constant.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.domain.Catalog;
import by.htp.rentStation.domain.Unit;


public class CatalogDAOStAXImpl implements CatalogDAO {

    @Override
    public Catalog getCatalogUnit() {
	return readCatalog(XML_FILE_PATH);
    }

    @Override
    public Catalog getCatalogRentUnit() {
	writeCatalogRentUnit(new Catalog());
	return readCatalog(XML_FILE_RENT_PATH);
    }
    
    private static Catalog readCatalog(String filePath) {
	Catalog catalog = new Catalog();
	XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	InputStream inputStream;
	try {
	    inputStream = new FileInputStream(filePath);
	    XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
	    CatalogStAXHandler stax = new CatalogStAXHandler();
	    catalog.setUnits(stax.proces(reader));

	} catch (FileNotFoundException | XMLStreamException e) {
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
	catalog = readCatalog(XML_FILE_PATH);
	CatalogStAXWriter stax = new CatalogStAXWriter();
	stax.writeCatalog(catalog, XML_FILE_RENT_PATH);

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
