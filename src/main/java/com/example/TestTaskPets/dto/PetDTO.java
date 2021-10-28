package com.example.TestTaskPets.dto;

import com.example.TestTaskPets.entity.Feed;
import com.example.TestTaskPets.entity.Pet;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PetDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("animal")
    private String animal;

    @JsonProperty("age")
    private int age;

    @JsonProperty("feeds")
    private List<FeedDTO> feedsListDTO;

    public PetDTO petToDTO(Optional <Pet> petOptional){
        feedsListDTO = new ArrayList<>();
        Pet pet = petOptional.isPresent()
                ? petOptional.get() : new Pet();
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setNickname(pet.getNickname());
        petDTO.setAnimal(pet.getAnimal());
        petDTO.setAge(pet.getAge());
        for(Feed feed : pet.getFeedsList()){
            FeedDTO feedDTO = new FeedDTO();
            feedDTO.setId(feed.getId());
            feedDTO.setTitle(feed.getTitle());
            feedsListDTO.add(feedDTO);
        }
        petDTO.setFeedsListDTO(feedsListDTO);
        return petDTO;
    }

    public List<PetDTO> petDTOList(List<Pet> petList){
        List<PetDTO> petDTOList = new ArrayList<>();
        for (Pet pet : petList){
            feedsListDTO = new ArrayList<>();
            PetDTO petDTO = new PetDTO();
            petDTO.setId(pet.getId());
            petDTO.setNickname(pet.getNickname());
            petDTO.setAnimal(petDTO.getAnimal());
            petDTO.setAge(pet.getAge());
            for(Feed feed : pet.getFeedsList()){
                FeedDTO feedDTO = new FeedDTO();
                feedDTO.setId(feed.getId());
                feedDTO.setTitle(feed.getTitle());
                feedsListDTO.add(feedDTO);
            }
            petDTO.setFeedsListDTO(feedsListDTO);
            petDTOList.add(petDTO);
        }
        return petDTOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<FeedDTO> getFeedsListDTO() {
        return feedsListDTO;
    }

    public void setFeedsListDTO(List<FeedDTO> feedsListDTO) {
        this.feedsListDTO = feedsListDTO;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
