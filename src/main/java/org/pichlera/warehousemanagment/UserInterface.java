package org.pichlera.warehousemanagment;

public interface UserInterface {

    public void run();
    public void outsource(); //remove Article
    public void stock(); //add Article
    public void inventory(); //get Article with position
    public void position(); //get Article position
    public void content(); //get Article from position
    public void configureWarehouse();
    public void help();
    public void configure();
}
