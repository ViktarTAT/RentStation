package by.htp.rentStation.dao.xml.dom;

import static by.htp.rentStation.util.Constant.*;
import static by.htp.rentStation.dao.DataTypeTransformUtil.*;
import static by.htp.rentStation.dao.xml.stax.MenuTagName.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.rentStation.dao.CatalogDAO;
import by.htp.rentStation.entity.Catalog;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.entity.equipment.Bike;
import by.htp.rentStation.dao.xml.stax.MenuTagName;



public class CatalogDAODOMImpl implements CatalogDAO {

    @Override
    public Catalog readCatalogUnit() {
	Catalog catalog = new Catalog();

	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db;
	try {
	    db = dbf.newDocumentBuilder();
	    Document document = db.parse(XML_FILE_PATH);
	    catalog.setUnits(parseDocument(document));
	} catch (ParserConfigurationException | SAXException | IOException e) {
	    e.printStackTrace();
	}

	return catalog;
    }

    private List<Unit> parseDocument(Document document) {
	List<Unit> units = new ArrayList<>();
	NodeList listUnits;
	
	Element root = document.getDocumentElement();
	listUnits = getListByTagName(root, BIKE);
	for(int i = 0; i < listUnits.getLength(); i++){
	    createBike(listUnits.item(i));
	}
	
	
	
	
	return units;
    }
    
    private NodeList getListByTagName(Element root, MenuTagName tagName){
	String tag = tagName.toString().toLowerCase();
	return root.getElementsByTagName(tag);
    }
    
    private static Element getTags(Node node, MenuTagName tagName) {
	Element element = (Element) node;
	String tag = tagName.toString().toLowerCase();
	NodeList list = element.getElementsByTagName(tag);
	Element child = (Element) list.item(0);
	return child;
    }
    
    private Unit createBike(Node node){
	Bike bike = new Bike();
	
	bike = (Bike)createUnit(node, bike);
	
	
	return bike;
    }
    
    private Unit createUnit(Node node, Unit unit){
	Element currentElement = (Element) node;
	
	String tagId =  ID.toString().toLowerCase();
	String id = currentElement.getAttribute(tagId);
	unit.setUnitId(convertId(id));
	
	currentElement = getTags(node, TITLE);
	String title = currentElement.getTextContent().trim();
	unit.setTitle(title);
	
	currentElement = getTags(node, PRICE);
	String priceString = currentElement.getTextContent().trim();
	BigDecimal price = new BigDecimal(priceString);
	unit.setPrice(price);
	return unit;
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
