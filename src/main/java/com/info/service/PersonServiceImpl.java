package com.info.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;




public class PersonServiceImpl implements PersonService {
    Connection cn = ConnexionDB.getConnexion();
    Statement st = null;

    @Override
    public boolean addPerson(Person p) {
        String sql = "INSERT INTO `person` (`name`,`age`) VALUES ('" + p.getName() + "'," + p.getAge() + ")";
        
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            System.out.println("Ajout avec succès");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur add");
            return false;
        }
    }

    @Override
    public boolean deletePerson(int id) {
        String sql = "DELETE FROM `person` WHERE id=" + id;
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Person getPersonByName(String name) {
        Person person = null;
        String sql = "SELECT `ID`, `Name`, `Age` FROM `person` WHERE name = '" + name + "'";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setAge(rs.getInt("age"));
                person.setName(rs.getString("name"));
            }
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Person getPerson(int id) {
        Person person = null;
        String sql = "SELECT `ID`, `Name`, `Age` FROM `person` WHERE id=" + id;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setAge(rs.getInt("age"));
                person.setName(rs.getString("name"));
            }
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Person[] getAllPersons() {
        Person[] persons = new Person[100];
        String sql = "SELECT * FROM `person`";
        try {
            int index = 0;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("Name"));
                person.setAge(rs.getInt("Age"));
                persons[index] = person;
                index += 1;
            }
            return persons;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

	@Override
	public List<Person> getALLPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean UpdatePerson(Person p) {
		// TODO Auto-generated method stub
		return false;
	}
}
