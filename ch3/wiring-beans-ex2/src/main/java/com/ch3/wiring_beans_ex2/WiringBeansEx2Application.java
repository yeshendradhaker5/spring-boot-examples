package com.ch3.wiring_beans_ex2;


import com.ch3.wiring_beans_ex2.config.ProjectConfig;
import com.ch3.wiring_beans_ex2.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WiringBeansEx2Application {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        System.out.println(person.getParrot().getName());
	}

}
