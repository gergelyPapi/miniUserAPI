package com.codecool.miniuserapi.assigment.Service;

import com.codecool.miniuserapi.assigment.Model.User;
import com.codecool.miniuserapi.assigment.Repository.UserRepository;
import com.codecool.miniuserapi.assigment.Utils.PasswordHashed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    PasswordHashed bcrypt = new PasswordHashed();

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

    public void registerUser (String userName, String email, String password, String authority) {
        String passwordHash = bcrypt.passwordHasher(password);
        User newUser = new User (userName, email, passwordHash, authority);
        userRepository.save(newUser);
    }
}
