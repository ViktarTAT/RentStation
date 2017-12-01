package by.htp.rentStation.dao.xml.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.entity.Catalog;
import by.htp.rentStation.entity.Unit;
import static by.htp.rentStation.util.Constant.*;

public class CatalogDAOStAXImpl implements CatalogDAO {

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
