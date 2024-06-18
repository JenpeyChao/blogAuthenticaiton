package com.example.blogAuthenticaiton.Controller;

import com.example.blogAuthenticaiton.Config.UsersDetails;
import com.example.blogAuthenticaiton.Entity.blog;
import com.example.blogAuthenticaiton.Entity.comment;
import com.example.blogAuthenticaiton.Entity.user;
import com.example.blogAuthenticaiton.Repository.UserDAO;
import com.example.blogAuthenticaiton.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserDAO userDAO;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/comments/all")
    public List<comment> getAllComments(){
        return this.commentService.getAllComments();
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/comments/nonhidden")
    public List<comment> getComments(){
        return this.commentService.getComment();
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @PostMapping("/comments")
    public comment addComment(@RequestBody comment comment, @AuthenticationPrincipal UsersDetails userDetails){
        user userDetail = userDAO.findById(userDetails.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        comment.setUserId(userDetail);
        comment.setShowComment(false);
        return this.commentService.addComment(comment);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/comments/{commentId}")
    public comment setComment(@PathVariable long commentId){
        comment comment = commentService.getCommentById(commentId);
        comment.setShowComment(true);
        return this.commentService.addComment(comment);
    }
}
