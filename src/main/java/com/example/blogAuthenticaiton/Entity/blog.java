package com.example.blogAuthenticaiton.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blogId;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private user userId;
    private String title;
    private String body;

}
