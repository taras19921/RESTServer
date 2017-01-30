package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

}
