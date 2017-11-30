package by.htp.rentStation.dao.xml.dom;

import static by.htp.rentStation.dao.DataTypeTransformUtil.*;
import static by.htp.rentStation.dao.xml.stax.MenuTagName.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.htp.rentStation.dao.xml.stax.MenuTagName;
import by.htp.rentStation.entity.Category;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.entity.accessory.Helmet;
import by.htp.rentStation.entity.accessory.Protect;
import by.htp.rentStation.entity.equipment.Bike;
import by.htp.rentStation.entity.equipment.Gender;
import by.htp.rentStation.entity.equipment.Roller;

public class ParserDOM {

    public List<Unit> parseDocument(Document document) {
	List<Unit> units = new ArrayList<>();
	NodeList listUnits;
	Unit unit;

	Element root = document.getDocumentElement();
	listUnits = getListByTagName(root, BIKE);
	for (int i = 0; i < listUnits.getLength(); i++) {
	    unit = createBike(listUnits.item(i));
	    units.add(unit);
	}
	
	listUnits = getListByTagName(root, ROLLER);
	for (int i = 0; i < listUnits.getLength(); i++) {
	    unit = createRoller(listUnits.item(i));
	    units.add(unit);
	}
	
	listUnits = getListByTagName(root, HELMET);
	for (int i = 0; i < listUnits.getLength(); i++) {
	    unit = createHelmet(listUnits.item(i));
	    units.add(unit);
	}
	
	listUnits = getListByTagName(root, PROTECT);
	for (int i = 0; i < listUnits.getLength(); i++) {
	    unit = createProtect(listUnits.item(i));
	    units.add(unit);
	}
	
	return units;
    }

    private NodeList getListByTagName(Element root, MenuTagName tagName) {
	String tag = tagName.toString().toLowerCase();
	return root.getElementsByTagName(tag);
    }

    private Element getTags(Node node, MenuTagName tagName) {
	Element element = (Element) node;
	String tag = tagName.toString().toLowerCase();
	NodeList list = element.getElementsByTagName(tag);
	Element child = (Element) list.item(0);
	return child;
    }
   
    private Unit createBike(Node node) {
	Bike bike = new Bike();
	bike = (Bike) createUnit(node, bike);

	Element currentElement = (Element) node;
	currentElement = getTags(node, GENDER);
	String genderString = currentElement.getTextContent().trim();
	Gender gender = Gender.getGender(genderString);
	bike.setGender(gender);

	currentElement = getTags(node, GROWTH);
	String growth = currentElement.getTextContent().trim();
	bike.setGrowth(convertInt(growth));

	return bike;
    }

    private Unit createRoller(Node node) {
	Roller roller = new Roller();
	roller = (Roller) createUnit(node, roller);

	Element currentElement = (Element) node;
	currentElement = getTags(node, GENDER);
	String genderString = currentElement.getTextContent().trim();
	Gender gender = Gender.getGender(genderString);
	roller.setGender(gender);

	currentElement = getTags(node, SIZE);
	String size = currentElement.getTextContent().trim();
	roller.setSize(convertInt(size));

	return roller;
    }
    
    private Unit createHelmet(Node node) {
	Helmet helmet = new Helmet();
	helmet = (Helmet) createUnit(node, helmet);

	Element currentElement = (Element) node;
	currentElement = getTags(node, SIZE);
	String size = currentElement.getTextContent().trim();
	helmet.setSize(size);

	currentElement = getTags(node, COLOR);
	String color = currentElement.getTextContent().trim();
	helmet.setColor(color);

	return helmet;
    }
    
    private Unit createProtect(Node node) {
	Protect protect = new Protect();
	protect = (Protect) createUnit(node, protect);

	Element currentElement = (Element) node;
	currentElement = getTags(node, SIZE);
	String size = currentElement.getTextContent().trim();
	protect.setSize(size);

	currentElement = getTags(node, GROWTH);
	String growth = currentElement.getTextContent().trim();
	protect.setGrowth(convertInt(growth));

	return protect;
    }

    private Unit createUnit(Node node, Unit unit) {
	Element currentElement = (Element) node;

	String tagId = ID.toString().toLowerCase();
	String id = currentElement.getAttribute(tagId);
	unit.setUnitId(convertInt(id));

	currentElement = getTags(node, TITLE);
	String title = currentElement.getTextContent().trim();
	unit.setTitle(title);

	currentElement = getTags(node, PRICE);
	String priceString = currentElement.getTextContent().trim();
	BigDecimal price = new BigDecimal(priceString);
	unit.setPrice(price);

	currentElement = getTags(node, CATEGORY);
	String categoryString = currentElement.getTextContent().trim();
	Category category = Category.getCategory(categoryString);
	unit.setCategory(category);

	return unit;
    }
}
