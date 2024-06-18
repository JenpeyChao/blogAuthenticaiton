package com.example.blogAuthenticaiton.Controller;

import com.example.blogAuthenticaiton.Config.UsersDetails;
import com.example.blogAuthenticaiton.Entity.blog;
import com.example.blogAuthenticaiton.Entity.user;
import com.example.blogAuthenticaiton.Repository.UserDAO;
import com.example.blogAuthenticaiton.Service.BlogService;
import com.example.blogAuthenticaiton.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BlogController {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String home(){
        return "Welcome to the blog";
    }

    @GetMapping("/blogs")
    public List<blog> getBlogs(){
        return this.blogService.getAllBlog();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/blogsAdmin")
    public blog addBlog(@RequestBody blog blog){
        return this.blogService.addBlog(blog);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/blogsUser")
    public blog addUserBlog(@RequestBody blog blog, @AuthenticationPrincipal UsersDetails userDetails){
        user userDetail = userDAO.findById(userDetails.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        blog.setUserId(userDetail);
        return this.blogService.addBlog(blog);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/blogs/all")
    public List<blog> getAllBlogs(){
        return this.blogService.getAllBlog();
    }

    @GetMapping("/blogs/{title}")
    public List<blog> getBlogByTitle(@PathVariable String title){
        return this.blogService.findBlogByTitle(title);
    }

}
