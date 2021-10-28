package com.example.TestTaskPets.service;

import com.example.TestTaskPets.dao.CustomerRepository;
import com.example.TestTaskPets.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private CustomerRepository customerRepository;


    public List<CustomerDTO> getAllCustomers(){
        CustomerDTO customerDTO = new CustomerDTO();
        return customerDTO.customerDTOList(customerRepository.findAll());
    }
}
