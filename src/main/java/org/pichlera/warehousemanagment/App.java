package org.pichlera.warehousemanagment;

/**
 *
 * @author Andreas Pichler
 * @version 23.10.2018
 * This is the App Class four the warehouse manager
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserInterface userInterface = new UserGui("Andi");
        userInterface.run();
    }
}
