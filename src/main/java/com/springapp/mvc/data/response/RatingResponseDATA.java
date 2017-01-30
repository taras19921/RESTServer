package com.springapp.mvc.data.response;

import java.util.Date;

public class RatingResponseDATA {

    private Integer id;
    private Integer userId;
    private Integer movieId;
    private String userName;
    private String movie;
    private Integer rating;
    private Date ratingDate;

    public RatingResponseDATA() {
    }

    public RatingResponseDATA(Integer id, String userName, String movie, Integer rating, Date ratingDate) {
        this.id = id;
        this.userName = userName;
        this.movie = movie;
        this.rating = rating;
        this.ratingDate = ratingDate;
    }

    public RatingResponseDATA(String movie) {
        this.movie = movie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }
}
