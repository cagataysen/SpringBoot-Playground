package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Spring context's purpose: we add the instances we expect Spring needs to manage
 */
@ComponentScan(basePackages = "main") //we tell Spring where to look for classes annotated with stereotype annotations (@Component)
@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot(){
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    //Adds the string "Hello" to the Spring context.
    @Bean
    String hello(){
        return "Hello";
    }

    //Adds the Integer 10 to the Spring context.
    @Bean
    Integer ten(){
        return 10;
    }

    //Adding same types of beans - No qualifying bean of type -- NoUniqueBeanDefinitionException
    @Bean
    Parrot parrot1(){
        var p = new Parrot();
        p.setName("Cagatay");
        return p;
    }

    //Any of the following syntaxes will change the name of the bean
    //@Bean("papaganName")
    //@Bean(value = "papaganName")
    @Bean(name = "papaganName")
    Parrot parrot2(){
        var p = new Parrot();
        p.setName("Papagan");
        return p;
    }

    //@Primary when you don't specify the bean you can use this and it will return this parrot
    @Bean
    Parrot parrot3(){
        var p = new Parrot();
        p.setName("Orhan");
        return p;
    }

    @Bean
    Dog dog(){
        var p = new Dog();
        p.setName("Tosia");
        return p;
    }

}
