package com.example.blogAuthenticaiton.Repository;

import com.example.blogAuthenticaiton.Entity.blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDAO extends JpaRepository<blog, Integer> {
}
