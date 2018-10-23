package org.pichlera.warehousemanagment;

public class CommandWords {

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

    public void showAll(){

        for(String command : validCommands){
            System.out.println(command);
        }
        System.out.println();
    }

    public String getValidCommandsWithAction(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < validCommands.length; i++){
            stringBuilder.append(validCommands[i] + " => " + commandsExplanation[i] + "\n");
        }
        return String.valueOf(stringBuilder);
    }
}
