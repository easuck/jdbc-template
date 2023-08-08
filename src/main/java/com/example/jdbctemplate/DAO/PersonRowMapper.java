package com.example.jdbctemplate.DAO;

import com.example.jdbctemplate.Entity.Adult;
import com.example.jdbctemplate.Entity.Kid;
import com.example.jdbctemplate.Entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        if (rs.getInt("age") >= 18){
            Adult adult = new Adult();
            adult.setName(rs.getString("name"));
            adult.setAge(rs.getInt("age"));
            adult.setJob(rs.getString("job"));
            return adult;
        }
        else{
            Kid kid = new Kid();
            kid.setName(rs.getString("name"));
            kid.setAge(rs.getInt("age"));
            kid.setGrade(rs.getInt("grade"));
            return kid;
        }
    }
}
