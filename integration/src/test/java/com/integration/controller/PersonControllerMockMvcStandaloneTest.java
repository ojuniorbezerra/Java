package com.integration.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.integration.controller.exception.PersonExceptionHandler;
import com.integration.exception.NotExistException;
import com.integration.model.Person;
import com.integration.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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


    @Test
    public void canRetrieveByIdWhenExists() throws Exception {

        given(personRepository.findById(1l)).willReturn(Optional.of(new Person()));

        MockHttpServletResponse response =
                mvc.perform(
                        get("/person/1").accept(MediaType.APPLICATION_JSON)
                ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString())
                .isEqualTo(
                        jsonPerson.write(new Person()).getJson()
                );
    }

    @Test
    public void canRetrieveByIdWhenDoesNotExist() throws Exception {
        // given
        given(personRepository.existsById(2l))
                .willThrow(new NotExistException());

        // when
        MockHttpServletResponse response = mvc.perform(
                get("/person/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getContentAsString()).isEmpty();
    }


}
