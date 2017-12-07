package by.htp.rentStation.dao.xml.sax;

import static by.htp.rentStation.dao.xml.MenuTagName.*;
import static by.htp.rentStation.dao.DataTypeTransformUtil.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.rentStation.dao.xml.MenuTagName;
import by.htp.rentStation.domain.Category;
import by.htp.rentStation.domain.Unit;
import by.htp.rentStation.domain.accessory.Accessory;
import by.htp.rentStation.domain.equipment.Equipment;
import by.htp.rentStation.domain.accessory.Helmet;
import by.htp.rentStation.domain.accessory.Protect;
import by.htp.rentStation.domain.equipment.Bike;
import by.htp.rentStation.domain.equipment.Gender;
import by.htp.rentStation.domain.equipment.Roller;

public class CatalogDataHandler extends DefaultHandler {
    private StringBuilder text;
    private Unit unit;
    private List<Unit> units = new ArrayList<>();

    public List<Unit> getList() {
	return units;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	MenuTagName tag = getTagName(localName);
	switch (tag) {
	case BIKE:
	    unit = new Bike();
	    setId(attributes);
	    break;
	case ROLLER:
	    unit = new Roller();
	    setId(attributes);
	    break;
	case HELMET:
	    unit = new Helmet();
	    setId(attributes);
	    break;
	case PROTECT:
	    unit = new Protect();
	    setId(attributes);
	    break;
	}
	text = new StringBuilder();
    }

    private void setId(Attributes attributes) {
	String tagId = getStringTagName(ID);
	int id = convertInt(attributes.getValue(tagId));
	unit.setUnitId(id);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
	MenuTagName tag = getTagName(localName);
	String textString = text.toString().trim();
	switch (tag) {
	case BIKE:
	case ROLLER:
	case HELMET:
	case PROTECT:
	    units.add(unit);
	    break;
	case TITLE:
	    unit.setTitle(text.toString().trim());
	    break;
	case PRICE:
	    BigDecimal price = new BigDecimal(textString);
	    unit.setPrice(price);
	    break;
	case CATEGORY:
	    Category category = Category.getCategory(textString);
	    unit.setCategory(category);
	    break;
	case GENDER:
	    Gender gender = Gender.getGender(textString);
	    if (unit instanceof Equipment) {
		Equipment equipment = (Equipment) unit;
		equipment.setGender(gender);
	    }
	    break;
	case SIZE:
	    if (unit instanceof Accessory) {
		Accessory accessory = (Accessory) unit;
		accessory.setSize(textString);
	    }
	    if (Roller.class.equals(unit.getClass())) {
		Roller roller = (Roller) unit;
		int size = convertInt(textString);
		roller.setSize(size);
	    }
	    break;
	case GROWTH:
	    if (Bike.class.equals(unit.getClass())) {
		Bike bike = (Bike) unit;
		int growth = convertInt(textString);
		bike.setGrowth(growth);
	    }
	    if (Protect.class.equals(unit.getClass())) {
		Protect protect = (Protect) unit;
		int growth = convertInt(textString);
		protect.setGrowth(growth);
	    }
	    break;
	case COLOR:
	    Helmet helmet = (Helmet)unit;
	    helmet.setColor(textString);
	    break;
	}
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
	text.append(ch, start, length);
    }

}
