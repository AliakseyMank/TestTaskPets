package com.example.TestTaskPets.dto;

import com.example.TestTaskPets.entity.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;


    public CustomerInfoDTO getCustomerInfoDTO() {
        return customerInfoDTO;
    }

    public void setCustomerInfoDTO(CustomerInfoDTO customerInfoDTO) {
        this.customerInfoDTO = customerInfoDTO;
    }

    @JsonProperty("Info")
    private CustomerInfoDTO customerInfoDTO;

    @JsonProperty("pets")
    private List<PetDTO> petsListDTO;

    public List<CustomerDTO> customerDTOList(List<Customer> customerList){
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customerList){
            PetDTO petDTO = new PetDTO();
            CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
            petsListDTO = new ArrayList<>();
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setFirstName(customer.getFirstName());
            customerDTO.setLastName(customer.getLastName());
            customerDTO.setCustomerInfoDTO(customerInfoDTO.customerInfoDTO(customer.getCustomerInfo()));
            petsListDTO = petDTO.petDTOList(customer.getPets());
            customerDTO.setPetsListDTO(petsListDTO);
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PetDTO> getPetsListDTO() {
        return petsListDTO;
    }

    public void setPetsListDTO(List<PetDTO> petsListDTO) {
        this.petsListDTO = petsListDTO;
    }
}
