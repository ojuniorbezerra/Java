package com.integration.service;

import com.integration.model.Person;
import com.integration.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Junior on 25/06/2020.
 */
@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        List<Person> result = new ArrayList<>();
        personRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Person> findPersonById(Long id){
        return personRepository.findById(id);
    }

    public void saveOrUpdate(Person person){
        personRepository.save(person);
    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }
}
