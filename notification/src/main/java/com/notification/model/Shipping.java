package com.notification.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Junior on 09/06/2020.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Shipping implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;
    private Date dtSend;
    private String describe;

}
