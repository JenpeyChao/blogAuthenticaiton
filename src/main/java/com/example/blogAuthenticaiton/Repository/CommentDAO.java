package com.example.blogAuthenticaiton.Repository;


import com.example.blogAuthenticaiton.Entity.blog;
import com.example.blogAuthenticaiton.Entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentDAO extends JpaRepository<comment, Integer> {
    @Query("select c from comment c where c.showComment = true")
    List<comment> findNonHiddenComment();

    @Query("select c from comment c where c.commentId = :commentId")
    comment findCommentById(@Param("commentId") long commentId);
}
