package by.htp.rentStation.dao.xml.dom;

import static by.htp.rentStation.util.Constant.XML_FILE_PATH;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.entity.Catalog;
import by.htp.rentStation.entity.Unit;

public class CatalogDAODOMImpl implements CatalogDAO {

    @Override
    public Catalog readCatalogUnit() {
	return readCatalog(XML_FILE_PATH);
    }

    @Override
    public Catalog readCatalogRentUnit() {
	return null;
    }
    
    private Catalog readCatalog(String filePath){
	Catalog catalog = new Catalog();

	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db;
	ParserDOM dom = new ParserDOM();
	try {
	    db = dbf.newDocumentBuilder();
	    Document document = db.parse(filePath);
	    List<Unit> units = dom.parseDocument(document);
	    catalog.setUnits(units);
	} catch (ParserConfigurationException | SAXException | IOException e) {
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
