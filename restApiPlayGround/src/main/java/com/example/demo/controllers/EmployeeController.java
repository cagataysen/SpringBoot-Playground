package com.example.demo.controllers;

import com.example.demo.entities.Employee;
import com.example.demo.entities.User;
import com.example.demo.repositories.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void init(){
        Employee employee2 = new Employee();

        employee2.setId("2");
        employee2.setName("Ola");
        employee2.setSurname("Gajda-Sen");

        employee2.setAddress("polska");
        employee2.setBirthday(Calendar.getInstance().getTime());
        employeeRepository.save(employee2);

    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Employee>> getEmployee(@PathVariable String search) {
        List<Employee> employees = employeeRepository.getByCustomQuery(search);
        return ResponseEntity.ok(employees);
    }

}
