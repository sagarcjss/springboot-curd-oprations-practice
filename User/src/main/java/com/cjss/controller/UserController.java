package com.cjss.controller;

import com.cjss.entity.Users;
import com.cjss.model.UsersModel;
import com.cjss.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    //To create User in Database........
    @PostMapping("user-save")
    public ResponseEntity<Users> saveUser(@RequestBody @Valid UsersModel usersModel){
        Users users = userService.saveUser(usersModel);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    //To get User by id provided by client which throws UserNotFoundException
    @GetMapping("get/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable String id){
        Users users = userService.getUserById(id);
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id){
        String message = userService.deleteUserById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("get-user/{email}")
    public ResponseEntity<Users> getUserByEmail(@PathVariable String email){
        Users users = userService.getUserByEmail(email);
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping("get-user-email/{email}/{mobileNum}")
    public ResponseEntity<Users> getUserByEmailAndMobileNum(@PathVariable String email, @PathVariable String mobileNum){
        Users users = userService.getUserByEmailAndMobileNum(email, mobileNum);
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

}
