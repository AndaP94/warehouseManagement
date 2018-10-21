package org.pichlera.warehousemanagment;

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
