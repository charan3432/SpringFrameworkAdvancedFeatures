package com.charan.demo3.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some Initialization logic");
        this.classA = classA;
    }

    public void show()
    {
        System.out.println("Something is printing.......");
    }
}


@Configuration
@ComponentScan
public class LazyInitializerLauncherApplication {

    public static void main(String args[])
    {
        try(var context = new AnnotationConfigApplicationContext(LazyInitializerLauncherApplication.class))
        {
            System.out.println("Intialization is completed");

            context.getBean(ClassB.class).show();

        }

    }
}
