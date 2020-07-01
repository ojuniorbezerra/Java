package com.integration.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.integration.model.Person;
import com.integration.service.PersonService;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerMockWithWebEnvironmentTest {

	
	
	@Autowired
    private MockMvc mvc;
    
    @MockBean
    private PersonService personService;

    @Autowired
    private JacksonTester<Person> jsonPerson;
    
    
    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
    	given(personService.findPersonById(1l)).willReturn(Optional.of(new Person()));
    	
    	
    	 MockHttpServletResponse response =  
    			 mvc.perform(get("/persons/1")
    					 .accept(MediaType.APPLICATION_JSON))
    			 .andReturn()
    			 .getResponse();
    	 
    	 assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
         assertThat(response.getContentAsString()).isEqualTo(
                 jsonPerson.write(new Person()).getJson()
         );    	
    	
    }
}
