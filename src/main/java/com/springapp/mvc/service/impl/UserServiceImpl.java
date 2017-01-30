package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.RatingDao;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RatingDao ratingDao;
}
