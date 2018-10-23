package org.pichlera.warehousemanagment;

/**
 * @author Andreas Pichler
 * @version 23.10.2018
 * This class represents the Store for the Article and matrix
 */
public class Store {

    Article[][] articleStore;

    /**
     * Create the store matrix
     * @param row
     * @param column
     */
    public Store(int row, int column) {
        this.articleStore = new Article[row][column];
    }

    public Article[][] getArticleStore() {
        return articleStore;
    }

    public void setArticleStore(Article[][] articleStore) {
        this.articleStore = articleStore;
    }

    public String toString(){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < articleStore.length; i++){
            for (int j = 0 ; j < articleStore[i].length; j++){
                try{

                    stringBuilder.append(articleStore[i][j].getArticledescription() + "\t\t");


                }catch (NullPointerException e){
                    stringBuilder.append("isempty\t\t");
                }

            }
            stringBuilder.append("\n\n");
        }

        return String.valueOf(stringBuilder);
    }
}
