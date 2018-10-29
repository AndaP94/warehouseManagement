package org.pichlera.warehousemanagment;
import java.util.ArrayList;


/**
 * @author Andreas Pichler
 * @version 23.10.2018
 * Warehouse interface
 */
public interface WarehouseInterface {

    public boolean configuration(int row, int column);
    public Store getStore();
    public Article getArticlePerId(int id);
    public Article getArticlePerDescription(String articleDescription);
    public Article getArticlePerPosition(Position position);
    public boolean addArticle(String articledescription, int price, Supplier supplier, PackageUnit packageUnit);
    public boolean removeArticlePerId(int id);
    public ArrayList<Article> getAllArticlesWithDetails();
    public Position getPositionFormArticle(Article article);
    public ArrayList<ArticleDTO> getArticleDescriptionAndId();
    public boolean addArticle(BasicArticle article);
    public boolean poolIsEmpty();
}
