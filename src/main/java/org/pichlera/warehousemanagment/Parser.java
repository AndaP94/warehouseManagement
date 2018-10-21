package org.pichlera.warehousemanagment;
import java.util.Scanner;


public class Parser {
    private CommandWords commands;
    private Scanner reader;


    public Parser(){
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

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

    public void showCommands(){
        commands.showAll();
    }

    public String readLine(){

        return reader.nextLine();
    }
}
