package com.sboot.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sboot.person.model.Address;
import com.sboot.person.model.Person;
import com.sboot.person.service.PersonService;

@SpringBootApplication
public class PersonDataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PersonDataApplication.class, args);
	}

	@Autowired
	private PersonService personService;


	@Override 
	public void run(String... args) throws Exception { 

		//TODO Auto-generated method stub 
		Person person = new Person();
		Address address = new Address();

		List<Address> addressLst = new ArrayList<Address>();
		
		address.setCity("Hyd"); 
		address.setState("TG"); 
		address.setStreetName("MYP");
		address.setZip("500049");
		
		addressLst.add(address);


		person.setFirstName("Ed"); 
		person.setLastName("Rose"); //
		person.setAddress(addressLst);
		person.setCreateDate(new Date());

		personService.createPerson(person); }


}
