package com.sboot.person.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sboot.person.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {
	
	//Create - Insert into Ticket
	
	//Update -> Update ticket
	
	//Read -> Select one record
	
	//Read -> Select all
	
	//Delete -> Delete record
	
	//Deleteall -> All Delete all

}
