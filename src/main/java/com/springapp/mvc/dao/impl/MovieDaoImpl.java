package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.MovieDao;
import com.springapp.mvc.model.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends BaseDaoImpl<Movie, Integer> implements MovieDao {

    public MovieDaoImpl() {
        super(Movie.class);
    }

    public void deleteMovies(int id1, int id2) {
        int result = entityManager.createNamedQuery(Movie.DELETE_MOVIES).setParameter(1, id1).setParameter(2, id2).executeUpdate();
        System.out.println(result);
        entityManager.flush();
    }
}
