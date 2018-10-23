package org.pichlera.warehousemanagment;

public class UserGui implements UserInterface {


    private WarehouseInterface warehouse;
    private Parser parser;
    private Database database;
    private String userName;
    private CommandWords commandWords;

    public UserGui(String userName){
        this.warehouse = null;
        this.parser = new Parser();
        this.database = new Database();
        this.userName = userName;
        this.commandWords = new CommandWords();
    }


    @Override
    public void run() {
        database.fillDatabaseDemo();
        System.out.println("Welcome to the Warehouse Application " + this.userName);
        System.out.println("First step pls type the size of the warehouse: ");
        configureWarehouse();

        String command;


        do {
            System.out.println("Type 'help' for a list of commands");
            command = parser.getCommand();

            switch (command){
                case "outsource": outsource(); break;
                case "stock": stock(); break;
                case "inventory": inventory(); break;
                case "position": position(); break;
                case "content": content(); break;
                case "store": showStore(); break;
                case "configure": configure(); break;
                case "help": help(); break;
                case "quit": command = "quit"; break;
                default:


            }

        }while (!(command.equals("quit")));

    }

    public void configureWarehouse(){

        do{


            try {
                System.out.println("Row: ");
                int row = Integer.valueOf(parser.readLine());
                System.out.println("Column: ");
                int column = Integer.valueOf(parser.readLine());

                if(row < 1 || column < 1){
                    System.out.println("pls type no negative number");
                }
                else {
                    this.warehouse = new SparesWarehouse(row,column);
                    break;
                }

            }catch (NumberFormatException e){
                System.out.println("Pls type a number. somthing went wrong");
            }

        }while (true);


    }

    @Override
    public void outsource() {

        do {


            if(warehouse.poolIsEmpty()){
                System.out.println("Store is empty...");
                break;
            }
            try {

                System.out.println("Pls type in the article you want to outsource with the id");
                System.out.println(warehouse.getArticleWithId());
                int id = Integer.valueOf(parser.readLine());

                if(warehouse.getArticlePerId(id) !=null && id > 0){
                    warehouse.removeArticlePerId(id);
                    System.out.println("article removed..");
                    break;
                }
                else{
                    System.out.println("pls take a wright Article ID");
                }

            }catch (NumberFormatException e){
                System.out.println("pls type no words ");
            }
        }while (true);

    }

    @Override
    public void stock() {


        boolean checkout = false;
        boolean isExistingArticle = false;
        Supplier supplier = null;
        int quantity = 0;
        String unit ;
        double price = 0;
        boolean check = false;
        PackageUnit packageUnit = null;
        BasicArticle newArticle = null;
        String articleName = "";



        do {


            System.out.println("Pls stock one Article into the store or choose a number for a exist article: ");

            do{

                System.out.println("\nArticle description: ");

                for (int i = 0; i < database.getBasicArticles().size(); i++){
                    System.out.println("\n" + i + ": " + database.getBasicArticles().get(i).toString());
                }

                articleName = parser.readLine();
                BasicArticle existingArticle = null;


                try{
                    int id = Integer.valueOf(articleName);


                    existingArticle = database.getBasicArticles().get(id);

                    do{
                        System.out.println("Ariclename: " + existingArticle.getArticledescription());
                        System.out.println("Do you only want the name or the whole article (y/n)");

                        String answer = parser.readLine().toLowerCase();

                        if(answer.equals("y")){
                            articleName = existingArticle.getArticledescription();
                            System.out.println("Articlename: " + articleName);
                            check = true;
                            break;
                        }
                        else if(answer.equals("n")){
                            isExistingArticle = true;
                            newArticle = existingArticle;
                            check = true;
                            break;
                        }

                        else{
                            System.out.println("pls type a right answer");
                        }

                    }while (true);


                }catch (NumberFormatException e){

                    System.out.println("Articlename: " + articleName);
                    check = true;

                }catch (IndexOutOfBoundsException e){
                    System.out.println("Article dosn't exists");
                }


            }while (!check);





            if(!(isExistingArticle)){

                System.out.println("Choose the Supplier or type 'new' for a new one: ");



                for(int i = 0; i < database.getSuppliers().size(); i++){
                    System.out.println(i + ": " + database.getSuppliers().get(i).toString());
                }

                do {

                    try {

                        int choose = Integer.valueOf(parser.readLine());
                        supplier = database.getSuppliers().get(choose);
                        check = true;

                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Pls type the right number");
                    }catch (NumberFormatException e){
                        System.out.println("Firstname: ");
                        String firstname = parser.readLine();
                        System.out.println("Lastname: ");
                        String lastname = parser.readLine();
                        System.out.println("Company: ");
                        String company = parser.readLine();
                        supplier = new Supplier(firstname, lastname, company);
                        check = true;
                        database.addSupplier(supplier);

                    }

                }while (!check);

                check = false;
                do {


                    try {
                        System.out.println("\nQuantitiy: ");

                        quantity = Integer.valueOf(parser.readLine());
                        check = true;


                    }catch (Exception e){
                        System.out.println("Pls type no words!");
                    }


                }while (!check);

                check = false;

                System.out.println("Unit: ");

                unit = parser.readLine();

                packageUnit = new PackageUnit(unit, quantity);

                System.out.println("Price per piece: ");

                do {

                    try {

                        price = Double.valueOf(parser.readLine());
                        check = true;

                    }catch (NumberFormatException e){
                        System.out.println("Pls type no words!");
                    }

                }while (!check);

                check = false;

                newArticle = new BasicArticle(articleName,price*packageUnit.getQuantity(),supplier,packageUnit);
            }



            do {

                System.out.println("Do you really want to add this Article?(y/n)");


                System.out.println(newArticle.toString());

                String answer = parser.readLine().toLowerCase();

                if(answer.equals("y")){
                    boolean checkArticle = warehouse.addArticle(newArticle);


                    if(checkArticle){
                        if(!isExistingArticle){
                            database.add(newArticle,supplier);
                        }
                        check = true;
                        checkout = true;
                        System.out.println("add Article");
                    }
                    else {
                        System.out.println("Somthing went wrong!");
                    }

                }
                else if(answer.equals("n")){
                    System.out.println("Ok! change Article ");
                    check = true;
                }
                else {
                    System.out.println("Type the wright answer");
                }


            }while (!check);

        }while (!checkout);

    }

    @Override
    public void inventory() {
        System.out.println("All Article in the Store: \n");

        System.out.println(warehouse.showAllArticleWithDetails());

    }

    @Override
    public void position() {

        boolean check = false;
        do{
            System.out.println("Type in the ID of the article and you get the store position of it: ");

            try {

                System.out.println(warehouse.getArticleWithId());

                int id = Integer.valueOf(parser.readLine());

                Article article = warehouse.getArticlePerId(id);

                if(article !=null){
                    System.out.println(warehouse.getPositionFormArticle(article) + "\n\n");
                    check = true;
                }
                else {
                    System.out.println("Article does not exists");
                }

            }catch (NumberFormatException e){
                System.out.println("Pls type no words.!");
            }


        }while (!check);

    }

    @Override
    public void content() {

        boolean check = false;

        do {
            System.out.println("Type the position from the Store and und get the content: ");

            try {

                System.out.println("Row: ");
                int row = Integer.valueOf(parser.readLine());
                System.out.println("Column: ");
                int column = Integer.valueOf(parser.readLine());


                Article article = warehouse.getArticlePerPosition(new Position(row,column));

                if(article !=null){
                    System.out.println(article.toString());
                    check = true;
                }
                else {
                    System.out.println("No Article! ");
                }


            }catch (NumberFormatException e){
                System.out.println("PLs type no words");
            }catch (IndexOutOfBoundsException e){
                System.out.println("The Position dosn't exists");
            }


        }while (!check);

    }

    @Override
    public void help() {

        System.out.println(commandWords.getValidCommandsWithAction());

    }

    @Override
    public void configure() {

        boolean check = false;
        do{
            System.out.println("Configure Store\nRow: ");

            int row = Integer.valueOf(parser.readLine());

            System.out.println("Column: ");

            int column = Integer.valueOf(parser.readLine());

            boolean isDone = warehouse.configuration(row,column);

            if(isDone){
                System.out.println("The configure was successful");
                check = true;
            }
            else{
                System.out.println("Not possible, your configure is to small");
                check = true;
            }

            try{}catch (NumberFormatException e){
                System.out.println("pls type no words! ");
            }


        }while (!check);


    }

    public void showStore(){

        System.out.println(warehouse.showStore());

    }
}
