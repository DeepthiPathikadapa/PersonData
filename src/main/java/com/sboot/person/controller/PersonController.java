package com.sboot.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.person.exception.PersonNotfoundException;
import com.sboot.person.model.Address;
import com.sboot.person.model.Person;
import com.sboot.person.service.AddressService;
import com.sboot.person.service.PersonService;

@RestController
@ControllerAdvice
@RequestMapping(value="/person") //http://localhost:8080/person
public class PersonController {
	
	//REST SERVICE CONCEPTS
	
	// @GET -> Getting Data -> @GetMapping -> @Get + @RequestMapping
	// @POST -> Creating Data -> @PostMapping -> @Post + @RequestMapping
	//@PUT -> Updating Data
	//@Delete -> Deleting Data
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private AddressService addressService;
	
	/*
	 * @PostMapping(value="/addperson") private Person addPerson(@RequestBody Person
	 * person) { return personService.createPerson(person); }
	 */
	
	@GetMapping(value="/all") //http://localhost:8080/person/all
	public Iterable<Person> getAllPersons(){
		
		return personService.getAllPersons();
		
	}
	
	@PostMapping(value="/create") //http://localhost:8080/person/create
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	
	@GetMapping(value="/{personId}") //http://localhost:8080/person/1
	public Person getPerson(
			@PathVariable("personId") Integer personId
						,Model model){
		return personService.getPerson(personId);
		
	}
	
	@GetMapping(value="/exp/{personId}") //http://localhost:8080/person/1
	public Person getPersonExp(
			@PathVariable("personId") Integer personId
						){
		Person p = personService.getPerson(personId);
		
		//return personService.getPerson(personId);
		if(p.getPersonId() == null) {
			throw new PersonNotfoundException( "No Person find with given ID");
		}else {
			return personService.getPerson(personId);
		}
		
	}
	
	
	@GetMapping(value="/count") //http://localhost:8080/person/1
	public long getPersonCount(){
		return personService.getPersonCount();
		
	}
	
	@DeleteMapping(value="/{personId}") //http://localhost:8080/person/1
	public void deletePerson(@PathVariable("personId") Integer personId) {
		
		personService.deletePerson(personId);
		
	}
	
	@PutMapping(value="/update/{personId}/{firstName}/{lastName}")
	//http://localhost:8080/person/update/1/a@b.com
	public Person updatePerson(
			@PathVariable("personId") Integer personId,
			@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		
		return personService.updatePerson(personId, firstName, lastName);
	}
	
	
	@PostMapping(value="/addAddress") //http://localhost:8080/person/addAddress
	public Iterable<Address> addAddress(@RequestBody List<Address> address) {
		return addressService.addAddressList(address);
	}
	
	@GetMapping(value="/getAddress") //http://localhost:8080/person/all
	public Iterable<Address> getAddress(){
		
		return addressService.getAllAddress();
		
	}
	
	@GetMapping(value="/address/{addressId}") //http://localhost:8080/person/1
	public Address getAddres(
			@PathVariable("addressId") Integer addressId
						){
		return addressService.getAddress(addressId);
		
	}
	
	@DeleteMapping(value="/address/{addressId}") //http://localhost:8080/person/1
	public void deleteAddress(@PathVariable("addressId") Integer addressId) {
		
		addressService.deleteAddress(addressId);
		
	}
	
	@PutMapping(value="/updateAddress/{addressId}/{street}/{city}")
	//http://localhost:8080/person/update/1/a@b.com
	public Address updateAddress(
			@PathVariable("addressId") Integer addressId,
			@PathVariable("streetName") String streetName,
			@PathVariable("city") String city) {
		
		return addressService.updateAddresss(addressId, streetName, city);
	}

}
