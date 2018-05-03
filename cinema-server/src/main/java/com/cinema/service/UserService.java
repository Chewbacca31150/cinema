package com.cinema.service;

import java.util.List;

import com.cinema.model.User;
import com.cinema.model.UserGeneral;
import com.cinema.model.UserRequest;

/**
 * Created by chewie
 */
public interface UserService {
  void resetCredentials();

  User findById(Long id);

  User findByUsername(String username);

  List<User> findAll();
  
  int findAllNumber();
  
  boolean checkPassword(String username, String password);
  
  void removeUser(String username);

  User save(UserRequest user);
  
  User save(UserGeneral user);
}
