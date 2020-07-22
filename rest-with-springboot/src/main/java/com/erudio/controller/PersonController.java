package com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erudio.model.Person;
import com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable Long id) {
		return personService.findById(id);
	}
	
	@GetMapping("/person")
	public List<Person> findAll() {
		return personService.findAll();
	}
	
	@PostMapping(value = "/person")
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}
	
	@PutMapping("/person")
	public Person update(@RequestBody Person person) {
		return personService.update(person);
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		personService.delete(id);
		return ResponseEntity.ok().build();
	}
}
