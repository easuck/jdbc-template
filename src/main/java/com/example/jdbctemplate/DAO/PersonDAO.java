package com.example.jdbctemplate.DAO;

import com.example.jdbctemplate.Entity.Adult;
import com.example.jdbctemplate.Entity.Kid;
import com.example.jdbctemplate.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("personDAO")
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("select * from persons", new PersonRowMapper());
    }

    public void save(Person person){
        if (person instanceof Adult){
            jdbcTemplate.update("insert into persons(name, age, job) values(?,?,?)", person.getName(), person.getAge(), ((Adult)person).getJob());
        }
        else if(person instanceof Kid){
            jdbcTemplate.update("insert into persons(name, age, grade) values(?,?,?)", person.getName(), person.getAge(), ((Kid)person).getGrade());
        }
    }

    public void delete(int id){
        jdbcTemplate.update("delete from persons where id=?", id);
    }


}
