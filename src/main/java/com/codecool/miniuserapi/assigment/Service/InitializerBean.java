package com.codecool.miniuserapi.assigment.Service;

import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(UserService userService) {

        userService.registerUser("TestAdmin","testAdmin@mail.com","321", "Admin");
        userService.registerUser("Test1","test1@mail.com","123", "Guest");
        userService.registerUser("Test2","test2@mail.com","1234", "Guest");
        userService.registerUser("Test3","test3@mail.com","12345", "Guest");
        userService.registerUser("Test4","test4@mail.com","123456", "Guest");

    }


}
