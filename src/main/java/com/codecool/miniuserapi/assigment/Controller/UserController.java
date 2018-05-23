package com.codecool.miniuserapi.assigment.Controller;

import com.codecool.miniuserapi.assigment.Model.User;
import com.codecool.miniuserapi.assigment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> getUserById(@PathVariable(value = "id") int id){
        Map<String , String> currentUserData = new HashMap<>();
        User currentUser = userService.getUserById(id);
        currentUserData.put("userId", Integer.toString(currentUser.getId()));
        currentUserData.put("userName", currentUser.getUserName());
        currentUserData.put("userEmail", currentUser.getUserEmail());
        if (currentUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(currentUserData, HttpStatus.OK);
        }
    }

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ResponseEntity<List<User>> registerUser(@RequestBody Map<String, String> data){
        String newUserUserName = data.get("userName");
        String newUserEMail = data.get("userEmail");
        String newUserPassword = data.get("password");
        userService.registerUser(newUserUserName, newUserEMail, newUserPassword,"Guest");
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers;
        allUsers = userService.getAllUsers();
        if (allUsers == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }
    }

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/delete_user/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int id){
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
