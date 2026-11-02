package com.ch5.beanscope4;


import com.ch5.beanscope4.config.ProjectConfig;
import com.ch5.beanscope4.model.User;
import com.ch5.beanscope4.service.CommentService;
import com.ch5.beanscope4.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScope4Application {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var cs = context.getBean(CommentService.class);
        var us = context.getBean(UserService.class);
        var user = context.getBean(User.class);

        System.out.println(user);

        System.out.println(cs.getDbRepository());
        System.out.println(us.getDbRepository());
        System.out.println(cs.getDbRepository() == us.getDbRepository());

    }

}
