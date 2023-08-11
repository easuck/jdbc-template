package com.example.jdbctemplate.Entity;

import com.example.jdbctemplate.Interfaces.Ageable;
import com.example.jdbctemplate.Interfaces.Nameable;

public abstract class Person implements Nameable, Ageable {

    private String name;
    private int age;
    private int id;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void printName(){
        System.out.println("Name is " + name);
    }

    @Override
    public void printAge(){
        System.out.println(name + " age is " + age);
    }

}
