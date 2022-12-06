package com.example.servicea.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

    private String id;
    private String name;
    private Map<String, Integer> skillsSet;

    public Employee(String name) {
        this.name = name;
    }
}
