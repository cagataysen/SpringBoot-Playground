package com.restClient.spring_boot_rest_template.api;

import com.restClient.spring_boot_rest_template.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private static final String webUrl = "http://localhost:8080/employee";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployeeList(){
        ResponseEntity result = restTemplate.getForEntity(webUrl,ResponseEntity.class);
        System.out.println(result);
        return null;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> kaydet(@RequestBody EmployeeDto employeeDto){
        ResponseEntity<EmployeeDto> result = restTemplate.postForEntity(webUrl, employeeDto, EmployeeDto.class);
        EmployeeDto responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }



}
