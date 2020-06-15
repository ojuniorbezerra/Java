package com.notification.controller;

import com.notification.service.ReguladorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by Junior on 10/06/2020.
 */

@RestController
@RequestMapping("/reguladores")
@CrossOrigin(origins = "*")
public class NotificationController implements Serializable{


    @Autowired
    private ReguladorService reguladorService;

}
