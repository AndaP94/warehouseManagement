package org.pichlera.warehousemanagment;


/**
 * @author Andreas Pichler
 * @version 23.10.2018
 * This class represents an article with ID and Position
 */
public class Article extends BasicArticle {

    private int articleId;

    private Position position;


    /**
     * Create a new Aricle
     * @param articledescription article name
     * @param articleId article id
     * @param price article price
     * @param pos article position
     * @param supplier article supplier
     * @param packageUnit article package unit
     */
    public Article(String articledescription, int articleId, double price, Position pos, Supplier supplier, PackageUnit packageUnit) {
        super(articledescription, price, supplier, packageUnit);
        this.articleId = articleId;
        this.position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }


    public String toString(){
        return "\n" + super.toString() + "\nArticleID: " + getArticleId() + "\nStore position: " + getPosition();
    }


}
