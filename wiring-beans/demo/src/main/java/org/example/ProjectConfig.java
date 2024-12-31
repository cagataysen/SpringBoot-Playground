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

    @Bean
    public Person person(){
        Person p = new Person();
        p.setName("Alex");
        return p;
    }


}
