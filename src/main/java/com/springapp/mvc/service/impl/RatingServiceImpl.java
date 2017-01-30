package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.RatingDao;
import com.springapp.mvc.data.response.RatingResponseDATA;
import com.springapp.mvc.model.Rating;
import com.springapp.mvc.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDao ratingDao;

    public List<RatingResponseDATA> findAllRating() {
        return ratingDao.findAllRating();
    }

    public List<RatingResponseDATA> findUserIdWithoutDate() {

        List<Rating> ratingList = ratingDao.findUserIdWithoutDate();
        if (ratingList != null) {
            for (Rating rating : ratingList) {
                rating.setRatingDate(new Date());
                ratingDao.update(rating);
            }
        }
        return ratingDao.findAllRating();
    }

    public List<Rating> task3() {

        return ratingDao.findMoviesIdByRating();
    }

    public List<RatingResponseDATA> task4() {

        return ratingDao.findMoviesWithoutRating();
    }
}
