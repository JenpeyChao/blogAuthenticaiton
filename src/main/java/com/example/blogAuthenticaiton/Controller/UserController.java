package com.example.blogAuthenticaiton.Controller;

import com.example.blogAuthenticaiton.Entity.user;
import com.example.blogAuthenticaiton.Repository.UserDAO;
import com.example.blogAuthenticaiton.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/addUser")
    public ResponseEntity<Object> saveUSer(@RequestBody user user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user result = userDAO.save(user);
        if (result.getUserId() > 0){
            return ResponseEntity.ok("USer Was Saved");
        }
        return ResponseEntity.status(404).body("Error, USer Not Saved");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/showUsers")
    public List<user> showUsers(){
        return this.userService.getAllUsers();
    }
}
