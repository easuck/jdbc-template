package com.example.jdbctemplate.Commands;

import com.example.jdbctemplate.DAO.PersonDAO;
import com.example.jdbctemplate.Entity.Person;
import com.example.jdbctemplate.Utility.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddCommand implements Command{

    private PersonDAO personDAO;
    private UserInput userInput;

    @Autowired
    public AddCommand(PersonDAO personDAO, UserInput userInput){
        this.personDAO = personDAO;
        this.userInput = userInput;
    }

    public AddCommand(){}


    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "adds entity to database";
    }

    @Override
    public void execute() {
        System.out.println("you're creating a person...");
        Person person = userInput.setFieldsOfEntity();
        personDAO.save(person);
        System.out.println("person has been saved to database");
    }
}
