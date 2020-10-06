package com.example.demo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public List<Person> getPersons() {
		List<Person> persons = repository.findAll();
		return persons;
	}
	
	public Person getPersonById(ObjectId id) {
		return repository.findById(id);
	}
	
	public void addPerson(Person person) {
		repository.save(person);
	}
	
	public void updatePersonById(Person person) {
		repository.save(person);
	}
	
	public void deletePersonById(ObjectId id) {
		repository.delete(repository.findById(id));
	}
	
}
