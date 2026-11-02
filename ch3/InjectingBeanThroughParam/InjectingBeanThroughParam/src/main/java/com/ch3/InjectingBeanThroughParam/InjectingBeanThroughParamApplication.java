package com.ch3.InjectingBeanThroughParam;


import com.ch3.InjectingBeanThroughParam.config.ProjectConfig;
import com.ch3.InjectingBeanThroughParam.model.Parrot;
import com.ch3.InjectingBeanThroughParam.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectingBeanThroughParamApplication {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);

        System.out.println(parrot.getName());

        System.out.println(person.getName());

        System.out.println(person.getParrot());
	}

}
