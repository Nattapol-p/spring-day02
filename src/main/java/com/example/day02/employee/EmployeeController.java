package com.example.day02.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public EmployeeResponse getById(@PathVariable int id){
        EmployeeResponse result = employeeService.get(id);
        return result;
    }

}
