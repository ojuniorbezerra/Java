package com.integration.repository;

import com.integration.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Junior on 25/06/2020.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

}
