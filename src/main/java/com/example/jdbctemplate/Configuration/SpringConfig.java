package com.example.jdbctemplate.Configuration;

import com.example.jdbctemplate.Commands.AddCommand;
import com.example.jdbctemplate.Commands.DeleteCommand;
import com.example.jdbctemplate.Commands.ShowCommand;
import com.example.jdbctemplate.DAO.PersonDAO;
import com.example.jdbctemplate.Utility.CommandsManager;
import com.example.jdbctemplate.Utility.UserInput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.example.jdbctemplate")
public class SpringConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/JDBCtemplate");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public UserInput userInput(){
        return new UserInput();
    }

    @Bean
    public PersonDAO personDAO(){
        return new PersonDAO(jdbcTemplate());
    }

    @Bean
    public AddCommand addCommand(){
        return new AddCommand(personDAO(), userInput());
    }

    @Bean
    public ShowCommand showCommand(){
        return new ShowCommand(personDAO());
    }

    @Bean
    public DeleteCommand deleteCommand(){
        return new DeleteCommand(personDAO(), userInput());
    }

    @Bean
    public CommandsManager commandsManager(){
        return new CommandsManager(addCommand(), showCommand(), deleteCommand());
    }



}
