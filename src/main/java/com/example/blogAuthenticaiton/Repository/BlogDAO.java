package com.example.blogAuthenticaiton.Repository;

import com.example.blogAuthenticaiton.Entity.blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogDAO extends JpaRepository<blog, Integer> {
    @Query("select b from blog b where b.title = :title")
    List<blog> findBlogByTitle(@Param("title") String title);
}
