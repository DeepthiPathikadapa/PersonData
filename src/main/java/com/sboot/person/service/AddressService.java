package com.sboot.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sboot.person.dao.AddressDao;
import com.sboot.person.dao.PersonDao;
import com.sboot.person.model.Address;
import com.sboot.person.model.Person;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	//Create Person
	
	public Address addAddress(Address address) {
		
		
		return addressDao.save(address);
		//save method will insert the data
	}
	
	public Iterable<Address> addAddressList(List<Address> address) {
		
		
		return addressDao.saveAll(address);
		//save method will insert the data
	}
	
	
	// Get All Person
	
	public Iterable<Address> getAllAddress(){
		
		return addressDao.findAll();
		
		//findAll -> select * from tbl_person;
		
	}
	
	
	// Get Person
	
	public Address getAddress(Integer addressId) {
		
		return addressDao.findById(addressId).orElse(new Address());
		
		//findById -> select * from tbl_person where person_id=personId
	}
	
	
	
	//Delete Person
	
	public void deleteAddress(Integer addressId) {
		addressDao.deleteById(addressId);
		
		//deleteById -> delete from tbl_person where person_id=personId
	}
	
	
	//Update Person
	public Address updateAddresss(Integer addressId,String streetName, String city) {
		
		
		//save Method -> Insert when no PRIMARY KEY in the data
		 //             ->update when PRIMARY KEY in the data
		
		Address dbAddressObj=getAddress(addressId);
		dbAddressObj.setStreetName(streetName);
		dbAddressObj.setCity(city);
		
		return addressDao.save(dbAddressObj);
		
	}
	
	public long getPersonCount() {
		return addressDao.count();
	}
	

}
