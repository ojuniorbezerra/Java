package com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erudio.data.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
