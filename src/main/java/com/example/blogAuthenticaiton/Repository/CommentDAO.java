package com.example.blogAuthenticaiton.Repository;


import com.example.blogAuthenticaiton.Entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentDAO extends JpaRepository<comment, Integer> {
    @Query("select c from comment c where c.showComment = :showComment")
    List<comment> findNonHiddenComment(@Param("showComment") Boolean showComment);
}
