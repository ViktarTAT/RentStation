package by.htp.rentStation.dao.xml.dom;

import static by.htp.rentStation.util.Constant.*;

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
	Catalog catalog = new Catalog();

	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db;
	try {
	    db = dbf.newDocumentBuilder();
	    Document document = db.parse(XML_FILE_PATH);
	    catalog.setEquipments(parseDocument(document));
	} catch (ParserConfigurationException | SAXException | IOException e) {
	    e.printStackTrace();
	}

	return catalog;
    }

    private List<Unit> parseDocument(Document document) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Catalog readCatalogRentUnit() {
	// TODO Auto-generated method stub
	return null;
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
