package org.pichlera.warehousemanagment;
import java.util.ArrayList;

public class Database implements DatabaseInterface {

    private ArrayList<BasicArticle> basicArticles;
    private ArrayList<Supplier> suppliers;

    public Database(){
        basicArticles = new ArrayList<>();
        suppliers = new ArrayList<>();
    }


    @Override
    public void add(BasicArticle article, Supplier supplier) {
        basicArticles.add(article);
        suppliers.add(supplier);
    }

    public void addSupplier(Supplier supplier){
        suppliers.add(supplier);
    }

    public void addArticle(BasicArticle article){
        basicArticles.add(article);
    }

    @Override
    public void remove() {

    }


    public ArrayList<BasicArticle> getBasicArticles() {
        return basicArticles;
    }

    public ArrayList<Supplier> getSuppliers(){
        return suppliers;
    }

    public void setBasicArticles(ArrayList<BasicArticle> basicArticles) {
        this.basicArticles = basicArticles;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public void fillDatabaseDemo(){

        Supplier sup1 = new Supplier("Andreas", "Pichler", "Halfen Schrauben Gmbh");

        Supplier sup2 = new Supplier("Harald", "Sprenger", "Habercorn Gmbh");

        PackageUnit packageUnit = new PackageUnit("Stueck", 20);

        BasicArticle article1 = new BasicArticle("M6 x 60", 0.60*packageUnit.getQuantity(), sup1, packageUnit);

        BasicArticle article2 = new BasicArticle("M8 x 80", 0.80*packageUnit.getQuantity(), sup2, packageUnit);

        add(article1,sup1);
        add(article2,sup2);

    }

}
