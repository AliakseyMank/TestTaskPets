package com.example.TestTaskPets.controller;

import com.example.TestTaskPets.dto.PetDTO;
import com.example.TestTaskPets.entity.Pet;
import com.example.TestTaskPets.service.PetServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Контроллер питомцев", description = "CRUD операции на питомцами")
@RestController
public class PetController {

    @Autowired
    public PetController(PetServiceImpl petService) {
        this.petService = petService;
    }

    private PetServiceImpl petService;

    @Operation(summary = "Создание нового питомца")
    @PostMapping(value = "/pet")
    public ResponseEntity<?> create(@RequestBody Pet pet){
        petService.create(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить информацию о питомце по ID")
    @GetMapping(value = "/pet/{id}")
    public ResponseEntity<PetDTO> getOnePet(@PathVariable(name = "id") Long id){
        final PetDTO pet = petService.findById(id);
        return petService.findById(id) != null
                ? new ResponseEntity<>(pet, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Удалить питомца по ID")
    @DeleteMapping(value = "/pet/{id}")
    public ResponseEntity<?> delete(@PathVariable (name = "id") Long id){
        return petService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }



    @Operation(summary = "Получить питомцев со страницы pageNum")
    @GetMapping(value = "/pet/pages/{pageNum}")
    public ResponseEntity<List<PetDTO>>getAllPets(@PathVariable (name = "pageNum") int pageNum){
       final List<PetDTO> petDTOList = petService.getAllPets(pageNum);
       return petDTOList != null && !petDTOList.isEmpty()
               ? new ResponseEntity<>(petDTOList, HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
