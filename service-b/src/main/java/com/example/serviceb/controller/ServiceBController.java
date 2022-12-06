package com.example.serviceb.controller;

import com.example.serviceb.service.ServiceBApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/b")
public class ServiceBController {

    private final ServiceBApp bApp;

    @Autowired
    public ServiceBController(ServiceBApp bApp) {
        this.bApp = bApp;
    }

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getSkills() {
        Map<String, Integer> skills = bApp.getSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
}
