package org.pichlera.warehousemanagment;


public class BasicArticle {

    private String articledescription;

    private double price;

    private Supplier supplier;

    private PackageUnit packageUnit;


    public BasicArticle(String articledescription, double price, Supplier supplier, PackageUnit packageUnit) {
        this.articledescription = articledescription;
        this.price = price;
        this.supplier = supplier;
        this.packageUnit = packageUnit;

        
    }

    public String getArticledescription() {
        return articledescription;
    }

    public void setArticledescription(String articledescription) {
        this.articledescription = articledescription;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public PackageUnit getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(PackageUnit packageUnit) {
        this.packageUnit = packageUnit;
    }


    public String toString(){
        return "Article description: " + getArticledescription() + "\nPrice: " + getPrice() + "\nPackage unit: " + getPackageUnit().toString() + "\nSupplier " + getSupplier();
    }
}

