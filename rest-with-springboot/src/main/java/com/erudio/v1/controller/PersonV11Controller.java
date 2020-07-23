package com.erudio.v1.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erudio.data.model.Person;
import com.erudio.services.PersonService;

@RestController
@RequestMapping("/person/v1.1")
public class PersonV11Controller {

	@Autowired
	private PersonService personService;
	
	
	@GetMapping("/")
	public List<Person> findAll() {
		int scores[] = new int[10];
		Arrays.asList(scores);
		return personService.findAll();
	}
	
}
