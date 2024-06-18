package com.example.blogAuthenticaiton.Controller;

import com.example.blogAuthenticaiton.Entity.comment;
import com.example.blogAuthenticaiton.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<comment> getComments(){
        return this.commentService.getAllComments();
    }

}
