package org.pichlera.warehousemanagment;

/**
 * @author Andreas Pichler
 * @version 23.10.2018
 *
 * This class represents a spare warehouse of screws
 */

public class SparesWarehouse implements WarehouseInterface{

    private Store store;


    /**
     * This creats a spares warehouse
     * @param row number of rows for the store
     * @param column number of columns for the store
     */
    public SparesWarehouse(int row, int column){
        store = new Store(row, column);
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }


    /**
     *
     *
     * This method reconfigures the warehouse to new rows and columns
     * @param row number of rows for the new store
     * @param column number of columns for the new store
     * @return true if the config was successfully
     */
    @Override
    public boolean configuration(int row, int column) {

        Store newStore = new Store(row, column);

        if((checkPool(row,column))){

            for (int i = 0; i < newStore.getArticleStore().length; i++){
                for (int j = 0; j < newStore.getArticleStore()[i].length; j++){

                    try{

                        newStore.getArticleStore()[i][j] = this.store.getArticleStore()[i][j];

                    }catch (Exception e){

                    }
                }
            }

            this.store = newStore;
            return true;

        }

        return false;

    }


    /**
     *
     * @return the whole store matrix
     */
    @Override
    public String showStore() {
        return this.store.toString();
    }


    /**
     *
     * This method returns an Article withe the ID
     * @param id Article ID
     * @return Article
     */
    @Override
    public Article getArticlePerId(int id) {

        if(ckeckId(id)){
            for (int i = 0; i < getStore().getArticleStore().length; i++) {
                for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {
                    if(getStore().getArticleStore()[i][j].getArticleId() == id){
                        return getStore().getArticleStore()[i][j];
                    }
                }
            }
        }
        return null;
    }


    /**
     * This method returns an Article with the article name
     * @param articleDescription article name
     * @return Article
     */
    @Override
    public Article getArticlePerDescription(String articleDescription) {

        if(checkArticleDesciption(articleDescription)){
            for (int i = 0; i < getStore().getArticleStore().length; i++) {
                for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {
                    if(getStore().getArticleStore()[i][j].getArticledescription().contains(articleDescription)){
                        return getStore().getArticleStore()[i][j];
                    }
                }
            }
        }
        return null;
    }

    /**
     * This method returns an Article with the position
     * @param position Position form Article
     * @return Article
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Article getArticlePerPosition(Position position) throws IndexOutOfBoundsException {

        return getStore().getArticleStore()[position.getX()][position.getY()];

    }


    /**
     *
     *
     * This method add an Article into the Store with all parameters
     * @param articledescription article name
     * @param price article price
     * @param supplier article supplier
     * @param packageUnit article package unit
     * @return true if the article was added
     */
    @Override
    public boolean addArticle(String articledescription,  int price,  Supplier supplier, PackageUnit packageUnit) {

        if(!(isfull())) {
            for (int i = 0; i < getStore().getArticleStore().length; i++) {
                for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {
                    if (getStore().getArticleStore()[i][j] == null) {
                        getStore().getArticleStore()[i][j] = new Article(articledescription, getId(), price, new Position(i, j), supplier, packageUnit);
                        return true;
                    }

                }
            }
        }

        return false;
    }


    /**
     * This method add an Article with the basic article
     * @param article Basicarticle
     * @return true if the Article was added
     */
    public boolean addArticle(BasicArticle article) {

        if(!(isfull())) {
            for (int i = 0; i < getStore().getArticleStore().length; i++) {
                for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {
                    if (getStore().getArticleStore()[i][j] == null) {
                        getStore().getArticleStore()[i][j] = new Article(article.getArticledescription(), getId(), article.getPrice(), new Position(i, j), article.getSupplier(), article.getPackageUnit());
                        return true;
                    }

                }
            }
        }

        return false;
    }


    /**
     * This method remove an article with the ID
     * @param id article ID
     */
    @Override
    public void removeArticlePerId(int id) {

        if(ckeckId(id)){
            for (int i = 0; i < getStore().getArticleStore().length; i++) {
                for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {

                    try {
                        if (getStore().getArticleStore()[i][j].getArticleId() == id) {
                            getStore().getArticleStore()[i][j] = null;
                        }
                    } catch (NullPointerException e) {

                    }
                }
            }
        }
    }


    /**
     *
     * @return all Article with details
     */
    public String showAllArticleWithDetails(){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < getStore().getArticleStore().length; i++) {
            for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {

                if(getStore().getArticleStore()[i][j] !=null){
                    stringBuilder.append(getStore().getArticleStore()[i][j].toString() + "\n\n");
                }
            }
        }

        return String.valueOf(stringBuilder);
    }

    /**
     * This method returns the position from an article
     * @param article Article
     * @return Position
     */
    @Override
    public Position getPositionFormArticle(Article article) {

        int id = article.getArticleId();

        if(ckeckId(id)){
            return getArticlePerId(id).getPosition();
        }
        return null;
    }


    /**
     *
     * @return articles with ID
     */
    public String getArticleWithId(){

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getStore().getArticleStore().length; i++) {
            for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {

                if(getStore().getArticleStore()[i][j] !=null) {
                    stringBuilder.append("Article ID: " + getStore().getArticleStore()[i][j].getArticleId() + "\tArticle: " + getStore().getArticleStore()[i][j].getArticledescription() + "\n");
                }
            }
        }
        return String.valueOf(stringBuilder);
    }


    /**
     *
     * @return true if the store pool is empty
     */
    public boolean poolIsEmpty(){
        for (int i = 0; i < getStore().getArticleStore().length; i++) {
            for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {

                if(getStore().getArticleStore()[i][j] != null){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * This method generate an article ID
     * @return ID
     */
    private int getId(){

        int id;
        int maxId = 0;
        for (int i = getStore().getArticleStore().length-1; i >= 0; i--) {
            for (int j = getStore().getArticleStore()[i].length - 1; j >= 0; j--) {
                try{

                  id = getStore().getArticleStore()[i][j].getArticleId();

                  if(id > maxId){
                    maxId = id;
                  }

                }catch (NullPointerException e){

                }
            }
        }
        id = maxId+1;
        return id;
    }


    /**
     * This method checks the store pool if its possible
     * @param row store row
     * @param column store column
     * @return true
     */
    private boolean checkPool(int row, int column) {

        for (int i = 0; i < getStore().getArticleStore().length; i++) {
            for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {
                if (getStore().getArticleStore()[i][getStore().getArticleStore()[i].length - 1] != null) {
                    return false;
                }
                if(getStore().getArticleStore()[(getStore().getArticleStore().length-1)][j] !=null) {
                    return false;
                }

                try {
                    if(getStore().getArticleStore()[i][column] !=null){
                        return false;
                    }
                }catch (ArrayIndexOutOfBoundsException e){

                }
                try {
                    if(getStore().getArticleStore()[row][j] !=null){
                        return false;
                    }
                }catch (ArrayIndexOutOfBoundsException e){

                }
            }
        }
        return true;
    }


    /**
     *
     * @return true if the pool is full
     */
    private boolean isfull() {
        for (int i = 0; i < getStore().getArticleStore().length; i++) {
            for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {

                if(getStore().getArticleStore()[i][j] == null ){
                    return false;
                }

            }
        }
        return true;
    }


    /**
     * This method checks if the if is avable
     * @param id article ID
     * @return true if the article is forgive
     */
    private boolean ckeckId(int id){
        for (int i = 0; i < getStore().getArticleStore().length; i++) {
            for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {


                try{
                    if(getStore().getArticleStore()[i][j].getArticleId() == id){
                        return true;
                    }
                }catch (NullPointerException e){

                }
            }
        }
        return false;
    }


    /**
     * This method checks if the article name is forgive
     * @param description article name
     * @return true if it was successfully
     */
    private boolean checkArticleDesciption(String description){

        for (int i = 0; i < getStore().getArticleStore().length; i++) {
            for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {

                if(getStore().getArticleStore()[i][j].getArticledescription().contains(description)){
                    return true;
                }
            }
        }
        return false;

    }


    /**
     *
     * @param pos Position
     * @return true if the pos is forgiven
     */
    private boolean checkPosition(Position pos){

        for (int i = 0; i < getStore().getArticleStore().length; i++) {
            for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {

                if(i == pos.getX() && j == pos.getY()){
                    return true;
                }
            }
        }
        return false;
    }


}
