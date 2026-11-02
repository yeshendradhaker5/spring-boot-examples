package com.ch5.beanscope1;


import com.ch5.beanscope1.config.ProjectConfig;
import com.ch5.beanscope1.model.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScope1Application {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		var cs1 = context.getBean(CommentService.class);
		var cs2 = context.getBean(CommentService.class);

		System.out.println(cs1==cs2);
		System.out.println(cs1);

	}


}
