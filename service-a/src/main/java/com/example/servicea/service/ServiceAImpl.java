package com.example.servicea.service;

import com.example.servicea.model.Employee;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ServiceAImpl implements ServiceAApp {

    private final RestTemplate restTemplate;
    private static final String SERVICE_B_URL = "http://127.0.0.1:9091/api/b";
    private static final String SERVICE_NAME = "serviceA";

    @Autowired
    public ServiceAImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    int count = 0;

    // @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "serviceAFallback")
     @Retry(name = SERVICE_NAME, fallbackMethod = "serviceAFallback")
   // @RateLimiter(name = SERVICE_NAME,fallbackMethod = "serviceAFallback")
    @Override
    public List<Employee> employeeList() {
        List<Employee> list = new ArrayList<>();

        System.err.println(" Retry to call " + ++count + " time Service B at  " + new Date());
        HttpEntity<Employee> requestEntity = new HttpEntity<>(null, new HttpHeaders());
        ResponseEntity<Map> result = restTemplate.exchange(SERVICE_B_URL, HttpMethod.GET, requestEntity, Map.class);

        Map<String, Integer> skills = result.getBody();
        list.add(new Employee(UUID.randomUUID().toString(), "A", skills));

        return list;
    }

    public List<Employee> serviceAFallback(Exception e) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Unfortunately! Service B has down.Try After Some time."));
        return list;
    }
}
