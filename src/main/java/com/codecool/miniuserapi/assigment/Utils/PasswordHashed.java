package com.codecool.miniuserapi.assigment.Utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashed {
    // Hash a password for the first time

    public String passwordHasher (String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public Boolean passwordVerifier (String candidate, String hashed) {
        return BCrypt.checkpw(candidate, hashed);
    }

}
