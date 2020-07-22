package com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.exception.ResourceNotFoundException;
import com.erudio.model.Person;
import com.erudio.repository.PersonRepository;

@Service
public class PersonService {


	private PersonRepository personRepository;
	

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	public Person create(Person person) {
		return personRepository.save(person);
	}

	public Person update(Person person) {
		Person entity = personRepository.findById(person.getId()).get();
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return personRepository.save(entity);
	}
	
	public void delete(Long id) {
		personRepository.deleteById(id);
	}
	
	public Person findById(Long id) {
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
	}
	
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
}
