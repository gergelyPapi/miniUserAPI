package com.codecool.miniuserapi.assigment.Service;

import com.codecool.miniuserapi.assigment.Model.User;
import com.codecool.miniuserapi.assigment.Repository.UserRepository;
import com.codecool.miniuserapi.assigment.Utils.PasswordHashed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById (Integer id) {
        User userToFind;
        try {
            userToFind = userRepository.findById(id);
            return userToFind;
        } catch (NullPointerException e) {
            System.out.println("User with that id was not found!");
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> allNews;
        allNews = userRepository.findAllUserWithGuestRole();
        return allNews;
    }

    public boolean deleteUser(int id) {
        User userToDelete = userRepository.findById(id);
        userRepository.delete(userToDelete);
        if (userRepository.findById(id) == null) {
            return true;
        } else {
            return false;
        }
    }
}
