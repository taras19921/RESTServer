package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.RatingDao;
import com.springapp.mvc.data.response.RatingResponseDATA;
import com.springapp.mvc.model.Rating;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class RatingDaoImpl extends BaseDaoImpl<Rating, Integer> implements RatingDao {

    public RatingDaoImpl() {
        super(Rating.class);
    }

    public List<RatingResponseDATA> findAllRating() {
        try {
            return entityManager.createNamedQuery(Rating.FIND_ALL_RATING).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Rating> findUserIdWithoutDate() {
        try {
            return entityManager.createNamedQuery(Rating.FIND_USER_ID_IN_RATING_WITHOUT_DATE).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Rating> findMoviesIdByRating() {
        try {
            return entityManager.createNamedQuery(Rating.FIND_MOVIES_ID_BY_RATING).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<RatingResponseDATA> findMoviesWithoutRating() {
        try {
            return entityManager.createNamedQuery(Rating.FIND_MOVIES_WITHOUT_RATING).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
