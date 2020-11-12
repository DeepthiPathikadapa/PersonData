package com.person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sboot.person.model.Person;

public class PersonDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		createPerson();
		getAllPersons();

	}

	public static void getAllPersons() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> reqEntity = new HttpEntity<String>(headers);
		
		String url = "http://localhost:8080/person/all";
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Person> entity = new HttpEntity<Person>(headers);
	      
	      System.out.println( restTemplate.exchange(
	         url, HttpMethod.GET, entity, String.class).getBody());

	}
	
	   public static void createPerson() {
		   RestTemplate restTemplate = new RestTemplate();
		   
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      //HttpEntity<Person> entity = new HttpEntity<Person>(person,headers);
	      
	      String url = "http://localhost:8080/person/create";
	      
	   // request body parameters
			Map<String, String> person = new HashMap<>();
			
			person.put("firstName", "reva");
			person.put("lastName", "vadla");

		    System.out.print(person);
		    
	      ResponseEntity<Void> response = restTemplate.postForEntity(url, person, Void.class);

	   // check response
	      if (response.getStatusCode() == HttpStatus.OK) {
	          System.out.println("Request Successful");
	      } else {
	          System.out.println("Request Failed");
	      }
	   }

	
}
