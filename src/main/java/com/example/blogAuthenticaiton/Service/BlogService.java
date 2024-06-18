package com.example.blogAuthenticaiton.Service;

import com.example.blogAuthenticaiton.Entity.blog;
import com.example.blogAuthenticaiton.Repository.BlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    public BlogDAO blogDAO;


    public List<blog> getAllBlog(){
        return this.blogDAO.findAll();
    }
    public blog addBlog(blog blog){
        return this.blogDAO.save(blog);
    }
    public List<blog> findBlogByTitle(String title){
        return blogDAO.findBlogByTitle(title);
    }
}
