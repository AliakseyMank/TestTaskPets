package com.example.TestTaskPets.controller;

import com.example.TestTaskPets.dto.CustomerDTO;
import com.example.TestTaskPets.service.CustomerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Контроллер хозяев питомце")
@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Operation(summary = "Получить информацию о всех хозяевах питомцев")
    @GetMapping(value = "/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        final List<CustomerDTO> customers = customerService.getAllCustomers();
        return customers != null && !customers.isEmpty()
                ? new ResponseEntity<>(customers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
