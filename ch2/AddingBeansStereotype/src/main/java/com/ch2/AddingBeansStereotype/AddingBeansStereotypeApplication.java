package com.ch2.AddingBeansStereotype;


import com.ch2.AddingBeansStereotype.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddingBeansStereotypeApplication {

	public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot);

	}

}
