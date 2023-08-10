package com.example.jdbctemplate.Commands;

public interface Command {

    String getName();
    String getDescription();
    void execute();
}
