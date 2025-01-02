package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Cagatay");
        return p;
    }

    /*WIRING beans 1: By calling the method in it
    *
    *
    @Bean
    public Person person(){
        Person p = new Person();
        p.setName("Alex");
        p.setParrot(parrot()); //wiring 1
        return p;
    }
*/

    /*WIRING 2: by adding the other bean as a parameter.*/
    @Bean
    public Person person(Parrot parrot){        //Spring injects the parrot bean into this parameter.
        Person p = new Person();
        p.setName("Alex");
        p.setParrot(parrot);
        return p;
    }

}
