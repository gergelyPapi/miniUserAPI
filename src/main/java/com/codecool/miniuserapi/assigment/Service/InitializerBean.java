package com.codecool.miniuserapi.assigment.Service;

import com.codecool.miniuserapi.assigment.Model.User;
import com.codecool.miniuserapi.assigment.Repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(UserService userService) {

        userService.registerUser("TestAdmin","testAdmin@mail.com","321", "Admin");
        userService.registerUser("Test1","test1@mail.com","123", "Guest");

    }


}
