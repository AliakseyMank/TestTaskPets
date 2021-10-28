package com.example.TestTaskPets.dao;

import com.example.TestTaskPets.entity.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Page<Pet> findAll(Pageable pageable);

    List<Pet> findAllById(Long id);
}
