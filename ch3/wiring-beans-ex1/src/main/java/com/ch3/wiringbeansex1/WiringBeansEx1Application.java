package com.ch3.wiringbeansex1;


import com.ch3.wiringbeansex1.config.ProjectConfig;
import com.ch3.wiringbeansex1.model.Parrot;
import com.ch3.wiringbeansex1.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WiringBeansEx1Application {

	public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);

        System.out.println(parrot.getName());
        System.out.println(person.getName());
        System.out.println(person.getParrot());
	}

}
