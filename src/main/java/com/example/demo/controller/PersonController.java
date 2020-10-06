package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/Person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Person> getAll() {
		return service.getPersons();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getById(@PathVariable("id") ObjectId id) {
		return service.getPersonById(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addP(@Valid @RequestBody Person p) {
		p.setId(ObjectId.get());
		service.addPerson(p);
		return "Successfully added";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String modifyPersonById(@PathVariable ObjectId id, @Valid @RequestBody Person p) {
		p.setId(id);
		service.updatePersonById(p);
		return "Successfully updated";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deletePersonById(@PathVariable ObjectId id) {
		service.deletePersonById(id);
		return "Successfully deleted";
	}
	
	@RequestMapping("/add")
	public String addUser(@RequestParam("name") String name, @RequestParam("email") String emailId, @RequestParam("pass") String password) {
		service.addPerson(new Person(ObjectId.get(),name,emailId,password));
		return "Successfully added";
	}
	
	@RequestMapping("/modify")
	public String modifyUser(@RequestParam("id") ObjectId id,@RequestParam("name") String name, @RequestParam("email") String emailId, @RequestParam("pass") String password) {
		service.updatePersonById(new Person(id,name,emailId,password));
		return "Successfully updated";
	}
	
	@RequestMapping("/delete")
	public String deleteUser(@RequestParam("id") ObjectId id) {
		service.deletePersonById(id);
		return "Successfully deleted";
	}
	
}
