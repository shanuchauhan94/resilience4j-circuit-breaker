package com.example.serviceb.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceBImpl implements ServiceBApp {

    @Override
    public Map<String, Integer> getSkills() {
        Map<String, Integer> map = new HashMap<>();
        map.put("AWS", 5);
        map.put("Java 8", 6);
        map.put("SpringBoot", 3);
        map.put("Microservice", 8);
        return map;
    }
}
