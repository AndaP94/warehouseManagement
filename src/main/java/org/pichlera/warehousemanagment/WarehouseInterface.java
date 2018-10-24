package org.pichlera.warehousemanagment;


/**
 * @author Andreas Pichler
 * @version 23.10.2018
 * Warehouse interface
 */
public interface WarehouseInterface {

    public boolean configuration(int row, int column);
    public String showStore();
    public Article getArticlePerId(int id);
    public Article getArticlePerDescription(String articleDescription);
    public Article getArticlePerPosition(Position position);
    public boolean addArticle(String articledescription, int price, Supplier supplier, PackageUnit packageUnit);
    public void removeArticlePerId(int id);
    public String showAllArticleWithDetails();
    public Position getPositionFormArticle(Article article);
    public String getArticleWithId();
    public boolean addArticle(BasicArticle article);
    public boolean poolIsEmpty();
}
