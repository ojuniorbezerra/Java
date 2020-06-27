package com.integration.controller;

import com.integration.model.Person;
import com.integration.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Junior on 25/06/2020.
 */
@RestController
public final class PersonController {


    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    private List<Person> getAllPerson(){
        return personService.findAll();
    }

    @GetMapping("/persons/{id}")
    private Person getPerson(@PathVariable("id") Long id) {
        return personService.findPersonById(id).orElse(null);
    }

    @DeleteMapping("/persons/{id}")
    private void deletePerson(@PathVariable("id") Long id) {
        personService.delete(id);
    }

    @PostMapping("/persons")
    private Long savePerson(@RequestBody Person person) {
        personService.saveOrUpdate(person);
        return person.getId();
    }
}
