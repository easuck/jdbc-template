package com.example.jdbctemplate.Entity;

import com.example.jdbctemplate.Interfaces.Jobable;

public class Adult extends Person implements Jobable {

    private String job;

    public Adult(String name, int age, String job) {
        super(name, age);
        this.job = job;
    }

    public Adult(){}

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void printJob() {
        System.out.println(getName() + " job is " + job);
    }

    @Override
    public String toString() {
        return "Adult{" +
                "name=" + getName() +
                ", age=" + getAge() +
                ", job=" + job +
                '}';
    }
}
