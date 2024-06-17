package com.example.blogAuthenticaiton.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String role;
    private String username;
    private String password;

}
