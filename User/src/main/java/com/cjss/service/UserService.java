package com.cjss.service;

import
        com.cjss.entity.Users;
import com.cjss.exception.UserNotFoundException;
import com.cjss.model.UsersModel;
import com.cjss.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // adding user into database
    public Users saveUser(UsersModel usersModel){
        Users user = new Users();
        user.setUserName(usersModel.getUserName());
        user.setEmail(usersModel.getEmail());
        user.setMobileNum(usersModel.getMobileNum());
        user.setGender(usersModel.getGender());
        user.setCity(usersModel.getCity());
        return userRepo.save(user);
    }

    //Getting User by id if not found it throws UserNotFoundException
    public Users getUserById(String id) throws UserNotFoundException {
        Optional<Users> user = userRepo.findById(id);
        if (user.isPresent()){
            return user.get();
        } else {
            throw new UserNotFoundException("User not found with the Id: " + id);
        }
    }

    public String deleteUserById(String id) throws UserNotFoundException {
        Optional<Users> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()){
            userRepo.delete(optionalUser.get());
            return "User Deleted";
        } else {
            throw new UserNotFoundException("User not found with the id: " + id);
        }
    }

    public Users getUserByEmail(String email) throws UserNotFoundException {
        Optional<Users> user = userRepo.findByEmail(email);
        if (user.isPresent()){
            return user.get();
        } else {
            throw new UserNotFoundException("User not found with the Email: " + email);
        }
    }

    public Users getUserByEmailAndMobileNum(String email, String mobileNum) throws UserNotFoundException {
        Optional<Users> user = userRepo.findByEmailAndMobileNum(email, mobileNum);
        if (user.isPresent()){
            return user.get();
        } else {
            throw new UserNotFoundException("User not found with the Email: " + email);
        }
    }

}
