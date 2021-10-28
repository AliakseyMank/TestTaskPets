package com.example.TestTaskPets.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "feeds")
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Basic
    @Column
    private String title;

    @ManyToMany(mappedBy = "feedsList" , fetch = FetchType.EAGER)

    private List<Pet> petsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Pet> getPetsList() {
        return petsList;
    }

    public void setPetsList(List<Pet> petsList) {
        this.petsList = petsList;
    }
}
