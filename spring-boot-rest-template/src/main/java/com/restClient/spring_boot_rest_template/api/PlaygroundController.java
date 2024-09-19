package com.restClient.spring_boot_rest_template.api;

import com.restClient.spring_boot_rest_template.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playground")
public class PlaygroundController {

    @Autowired
    RestTemplate restTemplate;

    private static final String webUrl = "http://localhost:8080/playground";

    @PostMapping
    private ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employee){
        employee.setId(1L);

        List<String> adresses = new ArrayList<>();
        adresses.add("asdsadsa");
        adresses.add("fmdskfmdsk");
        employee.setAddresses(adresses);

        employee.setName("CAGATAY");
        employee.setSurname("sen");

        try{
            restTemplate.postForObject(webUrl, employee, EmployeeDto.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(employee);

    }

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeDto> checkEmployee(@PathVariable Long id){

        try {

            String url = webUrl + "/" + id;
            return ResponseEntity.ok(restTemplate.getForObject(webUrl, EmployeeDto.class));

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }




}
