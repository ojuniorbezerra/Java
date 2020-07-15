package com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.erudio.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();

	public Person create(Person person) {
		return person;
	}

	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {

	}
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Junior");
		person.setLastName("Bezerra");
		person.setAddress("Ernesto Pedro");
		person.setGender("M");
		return person;
	}
	
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 15; i++) {
			persons.add(mockPerson(i));
		}
		return persons;
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Junior " + i);
		person.setLastName("Bezerra");
		person.setAddress("Ernesto Pedro");
		person.setGender("M");
		return person;
	}
}
