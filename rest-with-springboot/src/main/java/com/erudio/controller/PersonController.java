package com.erudio.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

import com.erudio.data.model.Person;
import com.erudio.data.vo.PersonVO;
import com.erudio.services.PersonService;

@RestController
@RequestMapping("/person/v1.0")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonVO findById(@PathVariable Long id) {
		PersonVO vo = new PersonVO(); 
		BeanUtils.copyProperties(personService.findById(id), vo);
		return vo;
	}
	
	@GetMapping(produces = { "application/json", "application/xml"})
	public List<Person> findAll() {
		return personService.findAll();
	}
	
	@PostMapping(value = "/", produces = {"application/json", "application/xml"},
			consumes = {"application/json", "application/xml"})
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}
	
	@PutMapping(value = "/", produces = {"application/json", "application/xml"},
			consumes = {"application/json", "application/xml"})
	public Person update(@RequestBody Person person) {
		return personService.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		personService.delete(id);
		return ResponseEntity.ok().build();
	}
}
