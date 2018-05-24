package com.codecool.miniuserapi.assigment.Controller;

import com.codecool.miniuserapi.assigment.Model.User;
import com.codecool.miniuserapi.assigment.Service.RegistrationService;
import com.codecool.miniuserapi.assigment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    UserService userService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<List<User>> registerUser(@RequestBody Map<String, String> data){
        String newUserUserName = data.get("userName");
        String newUserEMail = data.get("userEmail");
        String newUserPassword = data.get("password");
        registrationService.registerUser(newUserUserName, newUserEMail, newUserPassword,"Guest");
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
