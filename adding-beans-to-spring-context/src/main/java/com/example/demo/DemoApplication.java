package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		//Creating an instance of the Spring context. And adding in our configuration --> bean
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		//Gets a reference of a bean of type Parrot from the Spring context
		//Parrot p = context.getBean(Parrot.class); ---  more than same type of bean --> qualifying exception
		Parrot p = context.getBean("papaganName" ,Parrot.class);  //specifying bean name (method name)
		System.out.println(p.getName());

		String s = context.getBean(String.class);
		System.out.println(s);

		Integer n = context.getBean(Integer.class);
		System.out.println(n);

		Dog d = context.getBean(Dog.class);
		System.out.println(d.getName());


		//programmatically adding beans to the Spring context
		Dog x = new Dog();		//step1: create instance we want to add to the Spring context
		x.setName("osos");

		Supplier<Dog> dogSupplier = () -> x;		//step2: define supplier to return instance x

		//context: The ApplicationContext instance
		//"Polish Dog": the name we give to the bean that we add to the Spring context
		//dogSupplier: The Supplier returning the object instance that we add to the Spring context
		context.registerBean("Polish Dog", Dog.class, dogSupplier, bc -> bc.setPrimary(true));	//step3: call registerBean() method to add the instance to the Spring context.

		Dog c = context.getBean(Dog.class);		//verifying the bean is now in the context
		System.out.println(c.getName());



	}

}
