package com.integration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Junior on 25/06/2020.
 */
@Entity
@Table(name = "person")
@Getter @Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String email;
}
