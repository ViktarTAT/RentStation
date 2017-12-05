package by.htp.rentStation.entity.accessory;

import java.io.Serializable;

import by.htp.rentStation.entity.Category;

public class Helmet extends Accessory implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 7279231378323549491L;
    private String color;

    public Helmet() {

    }

    public Helmet(int equipmentId, String title, Category category, String price, String size, String color) {
	super(equipmentId, title, category, price, size);
	this.color = color;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((color == null) ? 0 : color.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Helmet other = (Helmet) obj;
	if (color == null) {
	    if (other.color != null)
		return false;
	} else if (!color.equals(other.color))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Helmet " + super.toString() + ", color= " + color;
    }

}
