package com.info.service;
import java.util.List;

public interface PersonService {
	public List<Person>getALLPersons();

	public boolean addPerson(Person p)  ;
	
	
	
	public boolean deletePerson(int id);
	
	
	public Person getPerson(int id);
	public boolean UpdatePerson(Person p);
	
	
	public Person getPersonByName(String name) ;

	Person[] getAllPersons();

	
	
	
}