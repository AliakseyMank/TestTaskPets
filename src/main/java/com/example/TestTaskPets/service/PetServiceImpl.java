package com.example.TestTaskPets.service;

import com.example.TestTaskPets.dao.PetRepository;
import com.example.TestTaskPets.dto.PetDTO;
import com.example.TestTaskPets.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl {

    private PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    public List<PetDTO> getAllPets(int pageNum){
        PetDTO petDTO = new PetDTO();
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        Page<Pet> content = petRepository.findAll(pageable);
        List<Pet> petList = content.getContent();
        return petDTO.petDTOList(petList);
    }

    public boolean delete(Long id) {
        petRepository.deleteById(id);
        return getOnePet(id) != null;

    }

    public List<PetDTO> getOnePet(Long id) {
        PetDTO petDTO = new PetDTO();
        List<Pet> petsById = petRepository.findAllById(id);
        return petDTO.petDTOList(petsById);
    }

    public void create(Pet pet) {
        petRepository.save(pet);
    }

    public PetDTO findById(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        PetDTO petDTO = new PetDTO();
        return petDTO.petToDTO(pet);
    }
}
