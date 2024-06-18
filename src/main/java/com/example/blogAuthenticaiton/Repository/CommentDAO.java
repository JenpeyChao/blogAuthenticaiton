package com.example.blogAuthenticaiton.Repository;

import com.example.blogAuthenticaiton.Entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<comment, Integer> {
}
