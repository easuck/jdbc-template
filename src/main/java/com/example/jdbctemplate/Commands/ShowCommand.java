package com.example.jdbctemplate.Commands;

import com.example.jdbctemplate.DAO.PersonDAO;
import com.example.jdbctemplate.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowCommand implements Command{

    private PersonDAO personDAO;

    @Autowired
    public ShowCommand(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    public ShowCommand(){}
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "shows all entities in database";
    }

    @Override
    public void execute() {
        List<Person> persons = personDAO.index();
        for (Person person : persons){
            System.out.println(person);
        }
    }
}
