package com.integration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.integration.model.Person;
import com.integration.service.PersonService;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PersonControllerMockRestTemplateTest {

	 @Autowired
	 private TestRestTemplate template;	

	
	@Autowired
    private MockMvc mvc;
    
    @MockBean
    private PersonService personService;
    
    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
    	given(personService.findPersonById(1l)).willReturn(Optional.of(new Person()));
    	
    	
    	 ResponseEntity<Person> result = template.withBasicAuth("actuator", "actuator123")
    	          .getForEntity("/persons/1", Person.class);
    	        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
