package org.pichlera.warehousemanagment;

/**
 * @version 29.10.2018
 * @author Andreas Pichler
 * This class represents the article DTO (Data tranform Object for the cmd output
 */
public class ArticleDTO{

    private int articleID;

    private String articleDescription;

    public ArticleDTO(int articleID, String articleDescription){
        this.articleID = articleID;
        this.articleDescription = articleDescription;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    @Override
    public String toString(){
        return "ArticleID: " + getArticleID() + " Article description: " + getArticleDescription();
    }
}