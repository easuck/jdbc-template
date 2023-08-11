package com.example.jdbctemplate.Utility;

import com.example.jdbctemplate.Entity.Adult;
import com.example.jdbctemplate.Entity.Kid;
import com.example.jdbctemplate.Entity.Person;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class UserInput {

    private Scanner scanner;

    public UserInput(){
        scanner = new Scanner(System.in);
    }

    public String setName(){
        String name;
        while(true){
            try{
                System.out.print("enter person's name: ");
                if(scanner.hasNext()){
                    name = scanner.nextLine().trim();
                    if(name.isEmpty()) throw new Exception();
                    break;
                }
            }
            catch(Exception e){
                System.out.println("name can't be empty");
            }
        }
        return name;
    }

    public int setAge() throws NumberFormatException{
        Optional<Integer> age;
        while(true){
            try{
                System.out.print("enter person's age: ");
                if(scanner.hasNext()){
                    age = Optional.of(Integer.parseInt(scanner.nextLine()));
                    if(age.isEmpty()|| age.get() < 0) throw new Exception();
                    break;
                }
            }
            catch(NumberFormatException e){
                System.out.println("age must be a number");
            }
            catch(Exception e){
                System.out.println("age can't be empty or negative");
            }
        }
        return age.get();
    }

    public int setGrade(){
        Optional<Integer> grade;
        while(true){
            try{
                System.out.print("enter kid's grade: ");
                if(scanner.hasNext()){
                    grade = Optional.of(Integer.parseInt(scanner.nextLine()));
                    if(grade.isEmpty()|| grade.get() < 1 || grade.get() > 11) throw new Exception();
                    break;
                }
            }
            catch(NumberFormatException e){
                System.out.println("grade must be a number");
            }
            catch(Exception e){
                System.out.println("grade must be from 1 to 11");
            }
        }
        return grade.get();
    }

    public String setJob(){
        String job;
        while(true){
            try{
                System.out.print("enter adult's job: ");
                if(scanner.hasNext()){
                    job = scanner.nextLine().trim();
                    if(job.isEmpty()) throw new Exception();
                    break;
                }
            }
            catch(Exception e){
                System.out.println("job can't be empty");
            }
        }
        return job;
    }

    public Person setFieldsOfEntity(){
        String name = setName();
        int age = setAge();
        if (age > 18) {
            Adult adult = new Adult();
            adult.setName(name);
            adult.setAge(age);
            adult.setJob(setJob());
            return adult;
        }
        else{
            Kid kid = new Kid();
            kid.setName(name);
            kid.setAge(age);
            kid.setGrade(setGrade());
            return kid;
        }
    }

    public int inputId(){
        Optional<Integer> id;
        while(true){
            try{
                System.out.print("enter id of entity you want to delete: ");
                if(scanner.hasNext()){
                    id = Optional.of(Integer.parseInt(scanner.nextLine()));
                    break;
                }
            }
            catch(NumberFormatException e){
                System.out.println("id must be a number");
            }
            /*catch(Exception e){
                System.out.println("id can't be empty");
            }*/
        }
        return id.get();
    }
}
