package com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.converter.DozerConverter;
import com.erudio.data.model.Person;
import com.erudio.data.vo.PersonVO;
import com.erudio.exception.ResourceNotFoundException;
import com.erudio.repository.PersonRepository;

@Service
public class PersonService {


	private PersonRepository personRepository;
	

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
	
	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonVO vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVO update(PersonVO person) {
		Person entity = personRepository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		PersonVO vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		personRepository.deleteById(id);
	}
	
	public PersonVO findById(Long id) {
		 Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		 return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	
	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
	}	
	
}
