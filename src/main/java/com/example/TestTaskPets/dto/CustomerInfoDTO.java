package com.example.TestTaskPets.dto;

import com.example.TestTaskPets.entity.CustomerInfo;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CustomerInfoDTO {
    @JsonProperty(value = "id")
    private Long id;


    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "email")
    private String email;

    public CustomerInfoDTO customerInfoDTO(CustomerInfo customerInfo){
        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
        customerInfoDTO.setId(customerInfo.getId());
        customerInfoDTO.setAddress(customerInfo.getAddress());
        customerInfoDTO.setEmail(customerInfo.getEmail());
        return customerInfoDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
