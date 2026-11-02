package com.ch5.beanscope2;


import com.ch5.beanscope2.config.ProjectConfig;
import com.ch5.beanscope2.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScope2Application {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        parrot.setName("Kopo");
        System.out.println(parrot.getName());

    }

}
