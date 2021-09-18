package com.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.RecordNotFoundException;
import com.demo.model.User;
import com.demo.model.UserRequest;
import com.demo.model.UserResponse;
import com.demo.service.UserService;

 
@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService service;

    
    @GetMapping
    public  List<UserResponse> getAllUsers() {
    	List<UserResponse> list = service.getAllUsers();
 
        return list;
    }
 
     
      @PostMapping
      public String  createOrUpdateUser(@RequestBody UserRequest user)
                                                      throws RecordNotFoundException {
      	  System.out.println("entity"+user.getDeptName());
      	  String message = service.createOrUpdateUser(user);
          return message;
      }
 
   
 
}