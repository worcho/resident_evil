package com.example.Resident.Evil.repositories;

import com.example.Resident.Evil.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select * from user where username=?1"
            ,nativeQuery = true)
    User findByUsername(String username);

    @Query(value = "select * from user where email=?1"
            ,nativeQuery = true)
    User findByEmail(String email);

}
