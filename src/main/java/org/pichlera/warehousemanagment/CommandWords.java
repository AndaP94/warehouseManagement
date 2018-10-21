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
            System.out.println(command + "\n");
        }
        System.out.println();
    }
}
