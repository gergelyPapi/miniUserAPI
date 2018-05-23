package com.codecool.miniuserapi.assigment.Repository;

import com.codecool.miniuserapi.assigment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Integer>{

    User findById (int id);
    @Query("SELECT u FROM User u WHERE u.userRole LIKE 'Guest'")
    List<User> findAllUserWithGuestRole();



}
