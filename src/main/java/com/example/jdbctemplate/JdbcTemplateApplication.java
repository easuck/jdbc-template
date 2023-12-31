package com.example.jdbctemplate;

import com.example.jdbctemplate.Configuration.SpringConfig;
import com.example.jdbctemplate.DAO.PersonDAO;
import com.example.jdbctemplate.Entity.Kid;
import com.example.jdbctemplate.Entity.Person;
import com.example.jdbctemplate.Utility.CommandsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		CommandsManager commandsManager = context.getBean("commandsManager", CommandsManager.class);
		commandsManager.doCommands();
	}

}
