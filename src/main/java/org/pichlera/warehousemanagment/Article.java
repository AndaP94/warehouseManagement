package org.pichlera.warehousemanagment;

public class Article extends BasicArticle {

    private int articleId;

    private Position position;




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
