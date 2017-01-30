package com.springapp.mvc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id") })
@NamedNativeQueries({
        @NamedNativeQuery(name = Movie.DELETE_MOVIES, query = "DELETE FROM movie WHERE movie.id= ? AND movie.id = ?")})
public class Movie {

    public static final String DELETE_MOVIES = "Movie.deleteMovies";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @Column(length = 500)
    private String title;
    @Column(length = 500)
    private String director;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private Set<Rating> stockDailyRecords = new HashSet<>(0);

    public Movie() {
    }

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public Movie(String title, String director, Set<Rating> stockDailyRecords) {
        this.title = title;
        this.director = director;
        this.stockDailyRecords = stockDailyRecords;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Set<Rating> getStockDailyRecords() {
        return stockDailyRecords;
    }

    public void setStockDailyRecords(Set<Rating> stockDailyRecords) {
        this.stockDailyRecords = stockDailyRecords;
    }
}