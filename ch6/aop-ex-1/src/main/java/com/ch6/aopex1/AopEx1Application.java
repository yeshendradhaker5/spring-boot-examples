package com.ch6.aopex1;

import com.ch6.aopex1.congig.ProjectConfig;
import com.ch6.aopex1.model.Comment;
import com.ch6.aopex1.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopEx1Application {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Initializing Comment Object
        Comment comment = new Comment("Demo comment", "Demo Name");

        var cs = context.getBean(CommentService.class);
        cs.publishComment(comment);
        cs.processComment(comment);
    }

}
