package com.cinema.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cinema.exception.ResourceConflictException;
import com.cinema.model.User;
import com.cinema.model.UserDelete;
import com.cinema.model.UserGeneral;
import com.cinema.model.UserRequest;
import com.cinema.service.UserService;

/**
 * Created by quentin
 */

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  @Autowired
  private UserService userService;
  
  @RequestMapping(method = GET, value = "/user/{userId}")
  public User loadById(@PathVariable Long userId) {
    return this.userService.findById(userId);
  }

  @RequestMapping(method = GET, value = "/user/all")
  public List<User> loadAll() {
    return this.userService.findAll();
  }

  @RequestMapping(method = GET, value = "/user/reset-credentials")
  public ResponseEntity<Map<String, String>> resetCredentials() {
    this.userService.resetCredentials();
    Map<String, String> result = new HashMap<>();
    result.put("result", "success");
    return ResponseEntity.accepted().body(result);
  }
  
  @RequestMapping(method = POST, value = "/user/save")
  public ResponseEntity<?> saveUser(@RequestBody UserGeneral userGeneral) {
    User existUser = this.userService.findByUsername(userGeneral.getUsername());
    if (existUser == null) {
      throw new ResourceConflictException(userGeneral.getId(), "User not found");
    }
	User user = this.userService.save(userGeneral);
	return new ResponseEntity<User>(user, HttpStatus.OK);
  }

  @RequestMapping(method = POST, value = "/signup")
  public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest,
      UriComponentsBuilder ucBuilder) {

    User existUser = this.userService.findByUsername(userRequest.getUsername());
    if (existUser != null) {
      throw new ResourceConflictException(userRequest.getId(), "Username already exists");
    }    
    User user = this.userService.save(userRequest);
        
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());
    return new ResponseEntity<User>(user, HttpStatus.CREATED);
  }

  /**
   * 
   * @return
   */
  @RequestMapping("/whoami")
  @PreAuthorize("hasRole('USER')")
  public User user() {
    return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }
  
  
  /**
   * 
   */
  @RequestMapping(value = "/user/delete", method=POST)
  public ResponseEntity<?> deleteUser(@RequestBody UserDelete userDelete){
	  if(userService.checkPassword(userDelete.getUsername(), userDelete.getPassword())) {
		  userService.removeUser(userDelete.getUsername());
		  return ResponseEntity.ok().build();
	  }
	  else {
		  return ResponseEntity.status(400).build();
	  }
	  
  }
  
}
