package com.example.blogAuthenticaiton.Repository;

import com.example.blogAuthenticaiton.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDAO  extends JpaRepository<user,Integer> {
    @Query(value = "select * from user where username = ?1", nativeQuery = true)
    Optional<user> findByEmail(String username);
}
