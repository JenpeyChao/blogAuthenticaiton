package com.example.blogAuthenticaiton.Service;

import com.example.blogAuthenticaiton.Entity.blog;
import com.example.blogAuthenticaiton.Entity.comment;
import com.example.blogAuthenticaiton.Repository.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;

    public List<comment> getAllComments(){
        return this.commentDAO.findAll();
    }

    public List<comment> getComment() {
        return this.commentDAO.findNonHiddenComment();
    }



    public comment addComment(comment comment){
        return this.commentDAO.save(comment);
    }

    public comment getCommentById(long commentId) {
        return this.commentDAO.findCommentById(commentId);
    }
}
