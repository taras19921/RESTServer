package com.springapp.mvc.service;

import com.springapp.mvc.data.response.RatingResponseDATA;
import com.springapp.mvc.model.Rating;

import java.util.List;

public interface RatingService {

    List<RatingResponseDATA> findAllRating();

    List<RatingResponseDATA> findUserIdWithoutDate();

    List<Rating> task3();

    List<RatingResponseDATA> task4();
}
