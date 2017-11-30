package by.htp.rentStation.dao.file;


import by.htp.rentStation.entity.Category;
import by.htp.rentStation.entity.Unit;
import by.htp.rentStation.entity.accessory.Helmet;
import by.htp.rentStation.entity.equipment.Bike;

public class FactoryRentUnit {
//	public static RentUnit createRentUnit(String rentEquipmentParameters) {
//		Equipment equipment;
//		RentUnit rentUnit = new RentUnit();
//		String[] mas = rentEquipmentParameters.split("&");
//		rentUnit.setRentDate(Double.parseDouble(mas[1]));
//		equipment = createEquipment(mas[0]);
//		rentUnit.setEquipment(equipment);
//		return rentUnit;
//	}

	public static Unit createUnit(String line, String delimeter) {
		Unit unit = null;
		String[] mas = line.split(delimeter);
		mas = trimLine(mas);
		switch (mas[0]) {
		case "Bike":
			//unit = new Bike(Integer.parseInt(mas[1]),mas[2], Category.SUMMER, mas[4]);
			break;
		case "Helmet":
			//unit = new Helmet(Integer.parseInt(mas[1]),mas[2], Category.SUMMER, mas[4]);
			break;
		}
		return unit;
	}
	
	private static String[] trimLine(String[] mas){
		for(int i = 0; i < mas.length; i++){
			mas[i] = mas[i].trim();
		}
		return mas;
	}
}
