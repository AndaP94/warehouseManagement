package org.pichlera.warehousemanagment;


/**
 * @author Andreas Pichler
 * @version 23.10.2018
 *
 * This Class represents the command words for the GUI
 */
public class CommandWords {

    /**
     * valid commands
     */
    private static final String validCommands[] = {
            "outsource" ,
            "stock",
            "inventory",
            "position",
            "content",
            "store",
            "configure",
            "help",
            "quit",

    };

    /**
     * explanation for the commands
     */
    private static final String commandsExplanation[] = {
            "Take article from stock",
            "Store article",
            "Views all articles with their information and storage position",
            "Query the storage location of an article",
            "Query the article for a specific storage position",
            "Views the whole store matrix",
            "Number of rows and columns be changeable",
            "Views the valid commands with their function",
            "exit the program",
    };

    /**
     *
     * @param aString input
     * @return true if the command input is valid
     */
    public boolean isCommand(String aString){

        if(aString !=null){
            for (int i = 0; i < validCommands.length; i++){
                if(validCommands[i].equals(aString)){
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * Shows all commands
     */
    public void showAll(){

        for(String command : validCommands){
            System.out.println(command);
        }
        System.out.println();
    }

    /**
     *
     * @return all commands with explanation
     */
    public String getValidCommandsWithAction(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < validCommands.length; i++){
            stringBuilder.append(validCommands[i] + " => " + commandsExplanation[i] + "\n");
        }
        return String.valueOf(stringBuilder);
    }
}
