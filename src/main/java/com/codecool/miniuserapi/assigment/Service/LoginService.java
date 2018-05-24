package com.codecool.miniuserapi.assigment.Service;

import com.codecool.miniuserapi.assigment.Model.User;
import com.codecool.miniuserapi.assigment.Repository.UserRepository;
import com.codecool.miniuserapi.assigment.Utils.PasswordHashed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    PasswordHashed bcrypt = new PasswordHashed();

    public Map<String, String> loginUser(String userName, String password) {
        HashMap checkedUserMap;
        String databaseHash;
        User currentUser;
        try {
            currentUser = userRepository.findByUserName(userName);
            databaseHash = currentUser.getPassword();
        } catch (NullPointerException e) {
            System.out.println("User was not found!");
            System.out.println(e.getStackTrace());
            return null;
        }
        if (bcrypt.passwordVerifier(password, databaseHash)) {
            checkedUserMap = new HashMap();
            checkedUserMap.put("userName", currentUser.getUserName());
            checkedUserMap.put("userRole", currentUser.getUserRole());
            return checkedUserMap;
        } else {
            return null;
        }

    }
}
