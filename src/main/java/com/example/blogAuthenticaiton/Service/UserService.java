package com.example.blogAuthenticaiton.Service;

import com.example.blogAuthenticaiton.Config.UsersDetails;
import com.example.blogAuthenticaiton.Entity.blog;
import com.example.blogAuthenticaiton.Entity.user;
import com.example.blogAuthenticaiton.Repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService{
    @Autowired
    private UserDAO userDAO;


    public List<user> getAllUsers(){
        return this.userDAO.findAll();
    }

}
