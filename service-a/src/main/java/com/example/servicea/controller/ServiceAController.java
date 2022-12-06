package com.example.servicea.controller;

import com.example.servicea.model.Employee;
import com.example.servicea.service.ServiceAApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/a")
public class ServiceAController {

    private final ServiceAApp aApp;

    @Autowired
    public ServiceAController(ServiceAApp aApp) {
        this.aApp = aApp;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> l = aApp.employeeList();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }
}
