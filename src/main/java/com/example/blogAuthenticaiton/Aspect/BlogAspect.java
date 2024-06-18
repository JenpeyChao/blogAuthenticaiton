package com.example.blogAuthenticaiton.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class BlogAspect {
    @Before("execution(* com.example.blogAuthenticaiton.Service.BlogService.*(..))")
    public void logBeforeBlog(JoinPoint joinPoint){
        log.info("Method:{}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.blogAuthenticaiton.Service.BlogService.*(..))", returning = "res")
    public void logAfterBlog(JoinPoint joinPoint, Object res){
        log.info("Method:{} Returning:{}", (joinPoint.getSignature().getName()),res);
    }

    @Before("execution(* com.example.blogAuthenticaiton.Service.CommentService.*(..))")
    public void logBeforeComment(JoinPoint joinPoint){
        log.info("Method:{}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.blogAuthenticaiton.Service.CommentService.*(..))", returning = "res")
    public void logAfterComment(JoinPoint joinPoint, Object res){
        log.info("Method:{} Returning:{}", (joinPoint.getSignature().getName()),res);
    }

    @Before("execution(* com.example.blogAuthenticaiton.Service.UserService.*(..))")
    public void logBeforeUser(JoinPoint joinPoint){
        log.info("Method:{}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.blogAuthenticaiton.Service.UserService.*(..))", returning = "res")
    public void logAfterUser(JoinPoint joinPoint, Object res){
        log.info("Method:{} Returning:{}", (joinPoint.getSignature().getName()),res);
    }
}
