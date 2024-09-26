package com.example.spring_boot_exception_handling.api;

import com.example.spring_boot_exception_handling.dto.Car;
import com.example.spring_boot_exception_handling.exception.EntityNotFoundException;
import com.example.spring_boot_exception_handling.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarApi {

    @Autowired
    private CarService carService;


    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name){
        return ResponseEntity.ok(carService.getCar(name));
    }
/*
    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound() {
        return "Record Not Found";
    }
*/
}
