package com.springapp.mvc.dao;

import com.springapp.mvc.data.response.RatingResponseDATA;
import com.springapp.mvc.model.Rating;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingDao extends BaseDao<Rating, Integer>/*extends JpaRepository<Rating, Integer>*/ {

    @Query("SELECT Rating.id, User.name, Movie.title, Rating.rating, Rating.ratingDate FROM Rating LEFT JOIN User ON Rating.userId = User.id LEFT JOIN Movie ON Rating.movieId = Movie.id")
    List<RatingResponseDATA> findAllRating();

    List<Rating> findUserIdWithoutDate();

    List<Rating> findMoviesIdByRating();

    List<RatingResponseDATA> findMoviesWithoutRating();
}
