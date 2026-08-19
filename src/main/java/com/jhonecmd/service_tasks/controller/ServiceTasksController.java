package com.jhonecmd.service_tasks.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceTasksController {

    @Value("${message:Hello default}")
    private String message;


    @GetMapping("/message")
    public String message(){
        return message;
    }
}
