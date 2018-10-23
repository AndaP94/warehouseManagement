package org.pichlera.warehousemanagment;

/**
 * @author Andreas Pichler
 * @version 23.10.2018
 * This class represents the package unit for the article
 */
public class PackageUnit {

    private String unit;
    private int quantity;

    public PackageUnit(String unit, int quantity) {
        this.unit = unit;
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString(){

        return getQuantity() + " " + getUnit();
    }
}
