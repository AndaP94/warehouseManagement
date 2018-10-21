package org.pichlera.warehousemanagment;


public class SparesWarehousec implements WarehouseInterface{

    private Store store;

    public SparesWarehousec(int row, int column){
        store = new Store(row, column);
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

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

    @Override
    public String showStore() {
        return this.store.toString();
    }

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


    @Override
    public Article getArticlePerPosition(Position position) throws IndexOutOfBoundsException {

        return getStore().getArticleStore()[position.getX()][position.getY()];

    }

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

    @Override
    public void removeArticlePerId(int id) {

        if(ckeckId(id)){
            for (int i = 0; i < getStore().getArticleStore().length; i++) {
                for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {

                    if(getStore().getArticleStore()[i][j].getArticleId() == id){
                        getStore().getArticleStore()[i][j] = null;
                    }
                }
            }
        }
    }

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

    @Override
    public Position getPositionFormArticle(Article article) {

        int id = article.getArticleId();

        if(ckeckId(id)){
            return getArticlePerId(id).getPosition();
        }
        return null;
    }

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

    private boolean ckeckId(int id){
        for (int i = 0; i < getStore().getArticleStore().length; i++) {
            for (int j = 0; j < getStore().getArticleStore()[i].length; j++) {

                if(getStore().getArticleStore()[i][j].getArticleId() == id){
                    return true;
                }
            }
        }
        return false;
    }

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
