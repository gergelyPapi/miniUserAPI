package com.codecool.miniuserapi.assigment.Utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashed {
    public String passwordHasher (String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public Boolean passwordVerifier (String plainTextPw, String hashedPw) {
        return BCrypt.checkpw(plainTextPw, hashedPw);
    }

}
