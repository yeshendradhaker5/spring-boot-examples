package com.ch4.spring_context_interface_ex1;


import com.ch4.spring_context_interface_ex1.config.ProjectConfig;
import com.ch4.spring_context_interface_ex1.model.Comment;
import com.ch4.spring_context_interface_ex1.proxies.proxiesImpl.EmailNotification;
import com.ch4.spring_context_interface_ex1.repository.repositoriyImpl.DBStoreComment;
import com.ch4.spring_context_interface_ex1.service.PublishComment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextInterfaceEx1Application {

	public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        PublishComment publishComment = context.getBean(PublishComment.class);
        Comment comment = new Comment("Printed");

        publishComment.publishComment(comment);

	}

}
