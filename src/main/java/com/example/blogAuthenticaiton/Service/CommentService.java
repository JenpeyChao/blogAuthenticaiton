package com.example.blogAuthenticaiton.Service;

import com.example.blogAuthenticaiton.Entity.comment;
import com.example.blogAuthenticaiton.Entity.user;
import com.example.blogAuthenticaiton.Repository.CommentDAO;
import jakarta.websocket.server.ServerEndpoint;
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
}
