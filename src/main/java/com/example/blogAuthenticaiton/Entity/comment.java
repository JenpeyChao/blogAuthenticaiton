package com.example.blogAuthenticaiton.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private user userId;
    @ManyToOne
    @JoinColumn(name = "blogId", nullable = false)
    private blog blogId;
    private String name;
    private String body;

}
