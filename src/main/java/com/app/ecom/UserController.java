package com.app.ecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
private UserService userService;


    @GetMapping("/api/users/{id}")
    public User getUser(@PathVariable Long id){
       return userService.fetchUser(id);

    }


    @GetMapping("/api/users")
    public  ResponseEntity<List<User>> getALlUsers(){
        return new  ResponseEntity<>(userService.fetchALlUsers(),
                HttpStatus.OK);
//        return   ResponseEntity.ok(userService.fetchALlUsers());

    }


    @PostMapping("/api/users")
    public String createUser(@RequestBody User user){
       userService.addUser(user);


     return  "User added Successfully";

    }
}
