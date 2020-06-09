package com.notification.model;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Junior on 09/06/2020.
 */
@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;
}
