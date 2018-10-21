package org.pichlera.warehousemanagment;

public interface DatabaseInterface {

    public void add(BasicArticle article, Supplier supplier);
    public void remove();
    public void addSupplier(Supplier supplier);
    public void addArticle(BasicArticle article);

}
