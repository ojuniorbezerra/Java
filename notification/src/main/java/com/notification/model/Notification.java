package com.notification.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Junior on 09/06/2020.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notification implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @OneToMany
    private List<SendNotification> sendNotifications;

}
