package by.htp.rentStation.dao.xml.sax;

import static by.htp.rentStation.dao.xml.MenuTagName.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.rentStation.dao.xml.MenuTagName;
import by.htp.rentStation.entity.Category;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.entity.accessory.Accessory;
import by.htp.rentStation.entity.accessory.Helmet;
import by.htp.rentStation.entity.accessory.Protect;
import by.htp.rentStation.entity.equipment.Bike;
import by.htp.rentStation.entity.equipment.Equipment;
import by.htp.rentStation.entity.equipment.Gender;
import by.htp.rentStation.entity.equipment.Roller;

public class CatalogDataHandler extends DefaultHandler {
	private StringBuilder text;
	private Unit unit;
	private List<Unit> units = new ArrayList<>();

	public List<Unit> getList() {
		return units;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		int id;
		MenuTagName tag = getTagName(localName);
		switch (tag) {
		case BIKE:
			unit = new Bike();
			id = parsId(attributes);
			unit.setUnitId(id);
			break;
		case ROLLER:
			unit = new Roller();
			id = parsId(attributes);
			unit.setUnitId(id);
			break;
		case HELMET:
			unit = new Helmet();
			id = parsId(attributes);
			unit.setUnitId(id);
			break;
		case PROTECT:
			unit = new Protect();
			id = parsId(attributes);
			unit.setUnitId(id);
			break;
		}
		text = new StringBuilder();
	}
	
	private static int parsId(Attributes attributes){
		return parsStringToInt(attributes.getValue("id"));
	}

	private static int parsStringToInt(String text) {
		return Integer.parseInt(text);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	    MenuTagName tag = getTagName(localName);
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
			BigDecimal price = new BigDecimal(text.toString().trim());
			unit.setPrice(price);
			break;
		case CATEGORY:
			Category category = Category.getCategory(text.toString());
			unit.setCategory(category);
			break;
		case GENDER:
			Gender gender = Gender.getGender(text.toString());
			if (unit instanceof Equipment) {
				Equipment equipment = (Equipment) unit;
				equipment.setGender(gender);
			}
			break;
		case SIZE:
			if (unit instanceof Accessory) {
				Accessory accessory = (Accessory) unit;
				accessory.setSize(text.toString());
			}
			if (Roller.class.equals(unit.getClass())) {
				Roller roller = (Roller) unit;
				int size = parsStringToInt(text.toString());
				roller.setSize(size);
			}
			break;
		case GROWTH:
			if (Bike.class.equals(unit.getClass())) {
				Bike bike = (Bike) unit;
				int growth = parsStringToInt(text.toString());
				bike.setGrowth(growth);;
			}
			if (Protect.class.equals(unit.getClass())) {
				Protect protect = (Protect) unit;
				int growth = parsStringToInt(text.toString());
				protect.setGrowth(growth);;
			}
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch, start, length);
	}

}
