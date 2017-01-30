package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.MovieDao;
import com.springapp.mvc.model.Movie;
import com.springapp.mvc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDao movieDao;

    public List<Movie> task2() {

        Movie movie9 = new Movie("Deadpool", "Tim Miller");
        Movie movie10 = new Movie("The 300 spartans", "Zak Snyder");
        movieDao.save(movie9);
        movieDao.save(movie10);

        return movieDao.findAll();
    }

    public List<Movie> task5(int id1, int id2) {

        List<Movie> movies = movieDao.findAll();
        if (movies != null) {
            for (Movie movie : movies) {
                if (movie.getId().equals(id1) || movie.getId().equals(id2))
                    movieDao.remove(movie);
            }

        }
//        movieDao.deleteMovies(id1, id2);
        return movieDao.findAll();
    }
}
