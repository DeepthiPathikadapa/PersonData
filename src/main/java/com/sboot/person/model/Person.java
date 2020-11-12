package com.sboot.person.model;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="person_id")
	private Integer personId;
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	
	  @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	  @JoinColumn(name = "person_id_fk", referencedColumnName = "person_id")
	  private List<Address> address;
	 
	
	/*
	 * @Column(name="address") private String address;
	 * 
	 * @Column(name="street_name") private String streetName;
	 * 
	 * @Column(name="city") private String city;
	 * 
	 * @Column(name="state") private String state;
	 * 
	 * @Column(name="zip") private String zip;
	 */
	
	@Column(name="create_date")
	private Date createDate;
	
	//@javax.persistence.Transient
	//private String realPassengerName;
	
	
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", createDate=" + createDate + "]";
	}
	public Person(Integer personId, String firstName, String lastName, List<Address> address, Date createDate) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.createDate = createDate;
	}
	public Person() {}
	
	
	
	
	

}
