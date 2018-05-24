package com.codecool.miniuserapi.assigment.Service;

import com.codecool.miniuserapi.assigment.Model.User;
import com.codecool.miniuserapi.assigment.Repository.UserRepository;
import com.codecool.miniuserapi.assigment.Utils.PasswordHashed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    PasswordHashed bcrypt = new PasswordHashed();

    public void registerUser (String userName, String email, String password, String authority) {
        String passwordHash = bcrypt.passwordHasher(password);
        User newUser = new User (userName, email, passwordHash, authority);
        userRepository.save(newUser);
    }
}
