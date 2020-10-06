package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Person {
	
	@Id
	private ObjectId id;
	
	private String name;
	private String emailId;
	private String password;
	
	public Person() {}

	public Person(ObjectId id, String name, String emailId, String password) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	
	public String getId() { return id.toHexString(); }
	public void setId(ObjectId id) { this.id = id; }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
