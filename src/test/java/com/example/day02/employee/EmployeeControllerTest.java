package com.example.day02.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    public void clearData(){
        employeeRepository.deleteAll();
    }

    @Test
    public void getById(){

       Employee demo = new Employee();
       demo.setName("nattapol");
       employeeRepository.save(demo);
       EmployeeResponse result =
        restTemplate.getForObject("/employee/1",EmployeeResponse.class);

       assertEquals(1,result.getId());
       assertEquals("nattapol",result.getName());
    }

}