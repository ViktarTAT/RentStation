package by.htp.rentStation.dao.xml.stax;

import static by.htp.rentStation.dao.DataTypeTransformUtil.convertInt;
import static by.htp.rentStation.dao.xml.MenuTagName.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

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

public class CatalogStAXHandler {
    Unit unit = null;

    public List<Unit> proces(XMLStreamReader reader) throws XMLStreamException {
	List<Unit> units = new ArrayList<>();
	MenuTagName tag = null;

	while (reader.hasNext()) {
	    int type = reader.next();

	    switch (type) {
	    case XMLStreamConstants.START_ELEMENT:
		tag = getTagName(reader.getLocalName());
		switch (tag) {
		case BIKE:
		    unit = new Bike();
		    setId(reader);
		    break;
		case ROLLER:
		    unit = new Roller();
		    setId(reader);
		    break;
		case HELMET:
		    unit = new Helmet();
		    setId(reader);
		    break;
		case PROTECT:
		    unit = new Protect();
		    setId(reader);
		    break;
		}
		break;
	    case XMLStreamConstants.END_ELEMENT:
		tag = getTagName(reader.getLocalName());
		switch (tag) {
		case BIKE:
		case ROLLER:
		case HELMET:
		case PROTECT:
		    units.add(unit);
		    break;
		}
		break;
	    case XMLStreamConstants.CHARACTERS:
		String text = reader.getText().trim();
		if (text.isEmpty()) {
		    break;
		}
		switch (tag) {
		case TITLE:
		    unit.setTitle(text);
		    break;
		case PRICE:
		    BigDecimal price = new BigDecimal(text);
		    unit.setPrice(price);
		    break;
		case CATEGORY:
		    Category category = Category.getCategory(text);
		    unit.setCategory(category);
		    break;
		case GENDER:
		    Gender gender = Gender.getGender(text);
		    if (unit instanceof Equipment) {
			Equipment equipment = (Equipment) unit;
			equipment.setGender(gender);
		    }
		    break;
		case SIZE:
		    if (unit instanceof Accessory) {
			Accessory accessory = (Accessory) unit;
			accessory.setSize(text);
		    }
		    if (Roller.class.equals(unit.getClass())) {
			Roller roller = (Roller) unit;
			int size = convertInt(text);
			roller.setSize(size);
		    }
		    break;
		case GROWTH:
		    if (Bike.class.equals(unit.getClass())) {
			Bike bike = (Bike) unit;
			int growth = convertInt(text);
			bike.setGrowth(growth);
			
		    }
		    if (Protect.class.equals(unit.getClass())) {
			Protect protect = (Protect) unit;
			int growth = convertInt(text);
			protect.setGrowth(growth);
			
		    }
		    break;
		case COLOR:
		    Helmet helmet = (Helmet)unit;
		    helmet.setColor(text);
		    break;
		}
		break;
	    }
	}
	return units;
    }

    private void setId(XMLStreamReader reader) {
	String tagId = getStringTagName(ID);
	String stringId = reader.getAttributeValue(null, tagId);
	int id = convertInt(stringId);
	unit.setUnitId(id);
    }
}
