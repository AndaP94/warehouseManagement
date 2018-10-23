package org.pichlera.warehousemanagment;

/**
 * @author Andreas Pichler
 * @version 23.10.2018
 * User interface
 */
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
