package com.ch5.beanscope3;

import com.ch5.beanscope3.config.ProjectConfig;
import com.ch5.beanscope3.model.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * This project is about singleton beanscope with multiple beans of same type using @Bean Annotation
 */
public class BeanScope3Application {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = context.getBean("commentService1" ,CommentService.class);
        var cs2 = context.getBean("commentService2" ,CommentService.class);

        System.out.println(cs1);
        System.out.println(cs2);

        System.out.println(cs1==cs2);

    }

}
