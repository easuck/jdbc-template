package com.example.jdbctemplate.Commands;

import com.example.jdbctemplate.DAO.PersonDAO;
import com.example.jdbctemplate.Utility.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommand implements Command{

    private PersonDAO personDAO;
    private UserInput userInput;

    @Autowired
    public DeleteCommand(PersonDAO personDAO, UserInput userInput) {
        this.personDAO = personDAO;
        this.userInput = userInput;
    }

    public DeleteCommand() {}

    @Override
    public String getName() {
        return "delete";
    }

    @Override
    public String getDescription() {
        return "deletes entity from database by id";
    }

    @Override
    public void execute() {
        int id = userInput.inputId();
        if(personDAO.delete(id)){
            System.out.println("entity was deleted");
        }
        else{
            System.out.println("no entity with such id");
        }
    }
}
