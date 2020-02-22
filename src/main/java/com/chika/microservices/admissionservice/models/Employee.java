package com.chika.microservices.admissionservice.models;



public class Employee {
	
	private String Id;
	private String firstName;
	private String lastName;
	private String specialty;
	
	public Employee() {}
	
	public Employee(String id, String firstName, String lastName, String specialty) {
		
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
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

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
	

}
