package com.springapp.mvc.controller;

import com.springapp.mvc.dao.MovieDao;
import com.springapp.mvc.dao.RatingDao;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.data.response.RatingResponseDATA;
import com.springapp.mvc.model.Movie;
import com.springapp.mvc.model.Rating;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.MovieService;
import com.springapp.mvc.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class RestServerController {

    @Autowired
    private MovieDao movieDao;
    @Autowired
    private RatingDao ratingDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", -1);
        model.addAttribute("taskId", -1);
        return "home";
    }

    @RequestMapping(value = "/task0", method = RequestMethod.GET)
    public String task0(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 0);
        model.addAttribute("taskId", 0);

        List<Movie> movies = movieDao.findAll();
        model.addAttribute("movies", movies);

        List<RatingResponseDATA> ratings = ratingService.findAllRating();
        model.addAttribute("ratings", ratings);
        return "task0";
    }

    @RequestMapping(value = "/task-id", method = RequestMethod.GET)
    public ResponseEntity<Integer> getTaskId(HttpServletRequest request) {

        HttpSession session = request.getSession();
        Integer taskId = (Integer) session.getAttribute("taskId");
        return new ResponseEntity<>(taskId, HttpStatus.OK);
    }

    @RequestMapping(value = "/task0movies", method = RequestMethod.GET)
    public String task0movies(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 0);
        model.addAttribute("taskId", 0);

        List<Movie> movies = movieDao.findAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @RequestMapping(value = "/task0users", method = RequestMethod.GET)
    public String task0users(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 0);
        model.addAttribute("taskId", 0);

        List<User> users = userDao.findAll();
        model.addAttribute("users", users);

        return "users";
    }

    @RequestMapping(value = "/task0ratings", method = RequestMethod.GET)
    public String task0ratings(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 0);
        model.addAttribute("taskId", 0);

        List<Rating> ratings = ratingDao.findAll();
        model.addAttribute("ratings", ratings);
        return "ratings";
    }

    @RequestMapping(value = "/task1", method = RequestMethod.GET)
    public String task1(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 1);
        model.addAttribute("taskId", 1);

        List<RatingResponseDATA> ratings = ratingService.findUserIdWithoutDate();
        model.addAttribute("ratings", ratings);
        return "ratings";
    }

    @RequestMapping(value = "/task2", method = RequestMethod.GET)
    public String task2(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 2);
        model.addAttribute("taskId", 2);

        List<Movie> movies = movieService.task2();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @RequestMapping(value = "/task3", method = RequestMethod.GET)
    public String task3(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 3);
        model.addAttribute("taskId", 3);

        List<Rating> ratings = ratingService.task3();
        model.addAttribute("ratings", ratings);
        return "task3";
    }

    @RequestMapping(value = "/task4", method = RequestMethod.GET)
    public String task4(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 4);
        model.addAttribute("taskId", 4);

        List<RatingResponseDATA> ratings = ratingService.task4();
        model.addAttribute("ratings", ratings);
        return "task4";
    }

    @RequestMapping(value = "/task5", method = RequestMethod.GET)
    public String task5(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 5);
        model.addAttribute("taskId", 5);

        List<Movie> movies = movieService.task5(9, 10);
        model.addAttribute("movies", movies);
        return "movies";
    }

    @RequestMapping(value = "/task6", method = RequestMethod.GET)
    public String task6(ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("taskId", 6);
        model.addAttribute("taskId", 6);

        List<RatingResponseDATA> ratings = ratingService.findAllRating();
        model.addAttribute("ratings", ratings);
        return "task6";
    }
}