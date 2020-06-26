package com.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integration.controller.exception.PersonExceptionHandler;
import com.integration.model.Person;
import com.integration.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by Junior on 25/06/2020.
 */
@ExtendWith(MockitoExtension.class)
public class PersonControllerMockMvcStandaloneTest {

    private MockMvc mvc;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    private JacksonTester<Person> jsonPerson;

    @BeforeEach
    private void Setup(){
        // Here we can't use @AutoConfigureJsonTesters because there isn't a Spring context
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(personController)
                .setControllerAdvice(PersonExceptionHandler.class)
                .addFilter(new PersonFilter()).build();
    }


}
