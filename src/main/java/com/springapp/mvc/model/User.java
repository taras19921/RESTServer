package com.springapp.mvc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id") })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @Column(length = 100)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Rating> rating = new HashSet<>(0);

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Set<Rating> rating) {
        this.name = name;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Rating> getRating() {
        return rating;
    }

    public void setRating(Set<Rating> rating) {
        this.rating = rating;
    }
}
