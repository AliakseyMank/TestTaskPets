package com.example.TestTaskPets.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "nickname")
    private String nickname;

    @Basic
    @Column
    private String animal;

    @Basic
    @Column
    private int age;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pets_feeds",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "feed_id")
    )
    private List<Feed> feedsList;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

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

    public List<Feed> getFeedsList() {
        return feedsList;
    }

    public void setFeedsList(List<Feed> feedsList) {
        this.feedsList = feedsList;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
