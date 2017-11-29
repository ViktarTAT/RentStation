package by.htp.rentStation.dao.xml;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.rentStation.entity.Category;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.entity.accessory.Helmet;
import by.htp.rentStation.entity.accessory.Protected;
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

		switch (localName) {
		case "bike":
			unit = new Bike();
			id = parsStringToInt(attributes.getValue("id"));
			unit.setUnitId(id);
			break;
		case "roller":
			unit = new Roller();
			id = parsStringToInt(attributes.getValue("id"));
			unit.setUnitId(id);
			break;
		case "helmet":
			unit = new Helmet();
			id = parsStringToInt(attributes.getValue("id"));
			unit.setUnitId(id);
			break;
		case "protected":
			unit = new Protected();
			id = parsStringToInt(attributes.getValue("id"));
			unit.setUnitId(id);
			break;
		}
		text = new StringBuilder();
	}

	private static int parsStringToInt(String text) {
		return Integer.parseInt(text);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
		case "bike":
		case "roller":
		case "helmet":
		case "protected":
			units.add(unit);
			break;
		case "title":
			unit.setTitle(text.toString().trim());
			break;
		case "price":
			BigDecimal price = new BigDecimal(text.toString().trim());
			unit.setPrice(price);
			break;
		case "category":
			Category category = Category.createCategory(text.toString());
			unit.setCategory(category);
			break;
		case "gender":
			Gender gender = Gender.createGender(text.toString());
			Equipment equipment = (Equipment) unit;
			equipment.setGender(gender);
			break;
		}
	}

	// private static double parseStringToDouble(String text){
	// return Double.parseDouble(text.trim());
	// }

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch, start, length);
	}

}
