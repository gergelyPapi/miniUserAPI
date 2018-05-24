package com.codecool.miniuserapi.assigment.Service;

import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(RegistrationService registrationService) {

        registrationService.registerUser("TestAdmin","testAdmin@mail.com","321", "Admin");
        registrationService.registerUser("Test1","test1@mail.com","123", "Guest");
        registrationService.registerUser("Test2","test2@mail.com","1234", "Guest");
        registrationService.registerUser("Test3","test3@mail.com","12345", "Guest");

    }


}
