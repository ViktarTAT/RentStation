package by.htp.rentStation.dao.xml.stax;

import static by.htp.rentStation.dao.xml.MenuTagName.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import by.htp.rentStation.dao.xml.MenuTagName;
import by.htp.rentStation.entity.Catalog;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.entity.equipment.Bike;

public class CatalogStAXWriter {
    public void writeCatalog(Catalog catalog, String filePath) {
	List<Unit> units = catalog.getUnits();
	XMLOutputFactory factory = XMLOutputFactory.newInstance();

	try {
	    XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(filePath));

	    writer.writeStartDocument();
	    writer.writeStartElement("units");

	    for (Unit unit : units) {
		
		if (unit != null) {
		    String string = unit.getClass().toString();
		    String[] temp = string.split("\\.");
		    String sunit = temp[temp.length - 1].toLowerCase();
		    MenuTagName tag = getTagName(sunit);
		    switch (tag) {
		    case BIKE:
			writeUnit(unit, tag, writer);
			Bike bike = (Bike)unit;
			

			break;
		    case ROLLER:
			writeUnit(unit, tag, writer);

			break;
		    case HELMET:
			writeUnit(unit, tag, writer);

			break;
		    case PROTECT:
			writeUnit(unit, tag, writer);
			
			break;
		    }
		    writer.writeEndElement();
		}
	    }

	    writer.writeEndElement();
	    writer.writeEndDocument();

	    writer.flush();
	    writer.close();

	} catch (XMLStreamException | IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private void writeUnit(Unit unit, MenuTagName tag, XMLStreamWriter writer) throws XMLStreamException {
	writer.writeStartElement(getStringTagName(tag));
	writer.writeAttribute(getStringTagName(ID), unit.getUnitId() + "");

	writer.writeStartElement(getStringTagName(TITLE));
	writer.writeCharacters(unit.getTitle());
	writer.writeEndElement();

	writer.writeStartElement(getStringTagName(CATEGORY));
	writer.writeCharacters(unit.getCategory().toString());
	writer.writeEndElement();

	writer.writeStartElement(getStringTagName(PRICE));
	writer.writeCharacters(unit.getPrice().toString());
	writer.writeEndElement();
    }
    
   
}
