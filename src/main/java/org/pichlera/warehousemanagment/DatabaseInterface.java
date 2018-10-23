package org.pichlera.warehousemanagment;


/**
 * @author Andreas Pichler
 * @version 23.10.2018
 * DatabaseInterface
 */
public interface DatabaseInterface {

    public void add(BasicArticle article, Supplier supplier);
    public void remove();
    public void addSupplier(Supplier supplier);
    public void addArticle(BasicArticle article);

}
