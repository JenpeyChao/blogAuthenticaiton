package com.example.blogAuthenticaiton.Config;
import com.example.blogAuthenticaiton.Entity.user;
import com.example.blogAuthenticaiton.Repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


@Configuration
public class UserDetailsServices implements UserDetailsService{
    @Autowired
    private UserDAO userdao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<user> user = userdao.findByUsername(username);
        return user.map(UsersDetails::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
    }
}
