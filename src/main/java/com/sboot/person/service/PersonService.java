package com.sboot.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sboot.person.dao.PersonDao;
import com.sboot.person.exception.PersonNotfoundException;
import com.sboot.person.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	//Create Person
	
	public Person createPerson(Person person) {
		
		
		return personDao.save(person);
		//save method will insert the data
	}
	
	
	// Get All Person
	
	public Iterable<Person> getAllPersons(){
		
		return personDao.findAll();
		
		//findAll -> select * from tbl_person;
		
	}
	
	
	// Get Person
	
	public Person getPerson(Integer personId) {
		if(personId != 0) {
			return personDao.findById(personId).orElse(new Person());
		}else {
			throw new PersonNotfoundException("No Person find with given ID");
		}
		
		//findById -> select * from tbl_person where person_id=personId
	}
	
	
	
	//Delete Person
	
	public void deletePerson(Integer personId) {
		if(personId != 0) {
			personDao.deleteById(personId);
		}else {
			throw new PersonNotfoundException("No Person find with given ID");
		}
		
		//deleteById -> delete from tbl_person where person_id=personId
	}
	
	
	//Update Person
	public Person updatePerson(Integer personId, String firstName, String lastName) {
		
		
		//save Method -> Insert when no PRIMARY KEY in the data
		 //             ->update when PRIMARY KEY in the data
		
		Person dbPersonObj=getPerson(personId);
		dbPersonObj.setFirstName(firstName);
		dbPersonObj.setLastName(lastName);
		
		return personDao.save(dbPersonObj); 
		
	}
	
	public long getPersonCount() {
		return personDao.count();
	}
	

}
