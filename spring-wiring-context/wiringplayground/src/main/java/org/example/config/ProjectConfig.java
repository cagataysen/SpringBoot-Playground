package org.example.config;

import org.example.beans.Cat;
import org.example.beans.Owner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.beans")
public class ProjectConfig {

    @Bean
    @Qualifier("cat1")
    public Cat cat1() {
        Cat c = new Cat();
        c.setName("Tom");
        return c;
    }

    @Bean
    @Qualifier("cat2")
    public Cat cat2() {
        Cat c = new Cat();
        c.setName("Leo");
        return c;
    }

    /*
    @Bean
    public Cat cat(){
        Cat c = new Cat();
        c.setName("cagatay");
        return c;
    }

    @Bean
    public Owner owner(Cat cat){
        Owner o = new Owner();
        o.setCat(cat); // it will actually fetch this cat from context
        return o;
    }

     */

}
