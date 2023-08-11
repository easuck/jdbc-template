package com.example.jdbctemplate.Utility;

import com.example.jdbctemplate.Commands.AddCommand;
import com.example.jdbctemplate.Commands.Command;
import com.example.jdbctemplate.Commands.DeleteCommand;
import com.example.jdbctemplate.Commands.ShowCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Scanner;

@Component
public class CommandsManager {

    private HashMap<String, Command> commands;
    private Scanner scanner;

    @Autowired
    public CommandsManager(AddCommand addCommand, ShowCommand showCommand, DeleteCommand deleteCommand){
        commands = new HashMap<>();
        scanner = new Scanner(System.in);
        commands.put("add", addCommand);
        commands.put("show", showCommand);
        commands.put("delete", deleteCommand);
    }

    public void doCommands(){
        System.out.print("enter command: ");
        while(scanner.hasNext()){
            String command = scanner.nextLine();
            if(commands.containsKey(command)){
                commands.get(command).execute();
                System.out.print("enter command: ");
            }
            else{
                System.out.println("no such command");
                System.out.print("enter command: ");
            }
        }
    }
}
