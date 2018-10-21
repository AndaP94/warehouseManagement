package org.pichlera.warehousemanagment;

public interface WarehouseInterface {

    public boolean configuration(int column, int row);
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
