package com.info.service;

public class Test {
    public static void main(String[] args) {
        try {
            PersonServiceImpl ps = new PersonServiceImpl();

            Person p1 = new Person(1, "chamseddine doula", 20);
            Person p2 = new Person(2, "yaacoub eya", 20);
            Person p3 = new Person(3, "chokri yassine", 20);
            
            System.out.println("Status = " + ps.addPerson(p1));
            System.out.println("Status = " + ps.addPerson(p2));
            System.out.println("Status = " + ps.addPerson(p3));
            
            ps.getAllPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
