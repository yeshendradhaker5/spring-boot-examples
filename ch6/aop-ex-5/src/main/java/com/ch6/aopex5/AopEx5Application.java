package com.ch6.aopex5;

import com.ch6.aopex5.config.ProjectConfig;
import com.ch6.aopex5.model.Comment;
import com.ch6.aopex5.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopEx5Application {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment("Demo Comment", "Demo Name");
        var cs = context.getBean(CommentService.class);
        String returnedValue = cs.publishComment(comment);
        System.out.println(returnedValue);
    }

}
