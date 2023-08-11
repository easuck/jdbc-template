package com.example.jdbctemplate.Entity;

import com.example.jdbctemplate.Interfaces.Gradeable;

public class Kid extends Person implements Gradeable {

    private int grade;

    public Kid(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public Kid(){}

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public void printGrade() {
        System.out.println(getName() + " is in " + grade + " grade");
    }

    @Override
    public String toString() {
        return "Kid{" +
                "name=" + getName() +
                ", age=" + getAge() +
                ", grade=" + grade +
                ", id=" + getId() +
                '}';
    }
}
