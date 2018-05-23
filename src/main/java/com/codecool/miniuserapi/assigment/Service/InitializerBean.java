package com.codecool.miniuserapi.assigment.Service;

import com.codecool.miniuserapi.assigment.Model.User;
import com.codecool.miniuserapi.assigment.Repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(UserRepository userRepository) {

        User testUser1 = new User("Test1", "test@mail.com", "123", "Guest");

        userRepository.save(testUser1);
    }


}
