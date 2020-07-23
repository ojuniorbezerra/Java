package com.erudio.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping(value = "/{id}")
	public PersonVO findById(@PathVariable Long id) {
		PersonVO vo = new PersonVO(); 
		BeanUtils.copyProperties(personService.findById(id), vo);
		return vo;
	}
	
	@GetMapping("/")
	public List<Person> findAll() {
		int scores[] = new int[10];
		Arrays.asList(scores);
		return personService.findAll();
	}
	
	@PostMapping(value = "/")
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}
	
	@PutMapping("/")
	public Person update(@RequestBody Person person) {
		return personService.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		personService.delete(id);
		return ResponseEntity.ok().build();
	}
}
