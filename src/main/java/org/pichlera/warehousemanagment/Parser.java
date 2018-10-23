package org.pichlera.warehousemanagment;
import java.util.Scanner;

/**
 * @author Andreas Pichler
 * @version 23.10.2018
 * This class is the parser to check the input of valid commands
 */
public class Parser {
    private CommandWords commands;
    private Scanner reader;

    /**
     *
     */
    public Parser(){
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * This method read the input and checks if the input is a valid command
     * @return commands
     */
    public String getCommand() {
        String command = null;

        do{

            System.out.print("> ");

            String word = readLine();
            if(commands.isCommand(word)) {
                command = word;
            }
            else{
                System.out.println("Unrecognized command: " + word);
                System.out.println("Valid commands are: ");
                commands.showAll();
            }

        }while (command == null);

        return command;
    }

    /**
     * Show all commands
     */
    public void showCommands(){
        commands.showAll();
    }

    /**
     * Input reader
     * @return input
     */
    public String readLine(){

        return reader.nextLine();
    }
}
