package com.springapp.mvc.dao;

import com.springapp.mvc.model.Movie;

public interface MovieDao extends BaseDao<Movie, Integer> {

    /*@Query("select u from User u where u.id =:id")
    User findUserwithCommodity(@Param("id") int id);*/

    void deleteMovies(int id1, int id2);
}
