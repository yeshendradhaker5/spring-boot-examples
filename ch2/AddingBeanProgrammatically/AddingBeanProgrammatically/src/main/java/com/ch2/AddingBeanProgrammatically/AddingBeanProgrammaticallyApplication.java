package com.ch2.AddingBeanProgrammatically;


import com.ch2.AddingBeanProgrammatically.config.ProjectConfig;
import com.ch2.AddingBeanProgrammatically.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class AddingBeanProgrammaticallyApplication {

	public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot parrot = new Parrot();
        parrot.setColor("green");
        parrot.setName("Koko");

        Parrot parrot2 = new Parrot();
        parrot2.setColor("orange");
        parrot2.setName("KoPo");
        Supplier<Parrot> parrotSupplier = () -> parrot;

        if(parrot.getColor().equals("green")){
            context.registerBean("parrot1", Parrot.class, parrotSupplier, bc->bc.setPrimary(true));

            // if second bean exist then by default will get the bean defined as Primary.
            context.registerBean("parrot2", Parrot.class, parrotSupplier);
        }

        Parrot parronBean = context.getBean(Parrot.class);
        System.out.println(parronBean);
        System.out.println(parronBean.getColor());
        System.out.println(parronBean.getName());

	}

}
