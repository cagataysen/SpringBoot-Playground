package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * Imagine we have no Spring Boot application, but only Java project and Maven.
 *
 * Spring context dependency:
 *
 *      <dependency>
 * 			<groupId>org.springframework</groupId>
 * 			<artifactId>spring-context</artifactId>
 * 			<version>5.2.6.RELEASE</version>
 * 		</dependency>
 *
 *
 * Spring is being modular. So you don't have to add whole framwork to your app when you use something
 * out of the Spring ecosystem.
 */
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
