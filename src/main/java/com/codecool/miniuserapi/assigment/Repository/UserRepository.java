package com.codecool.miniuserapi.assigment.Repository;

import com.codecool.miniuserapi.assigment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer>{

    User findById (int id);
}
