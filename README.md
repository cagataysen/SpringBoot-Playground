# Spring Boot Documentation

## Overview
`@SpringBootApplication` is a convenience annotation that combines the following three annotations:
- `@EnableAutoConfiguration`
- `@ComponentScan`
- `@Configuration`

## Common Annotations
- `@RestController`: Marks a class as a controller where every method returns a domain object instead of a view. It's a combination of `@Controller` and `@ResponseBody`.
- `@RequestBody`: Indicates that a method parameter should be bound to the body of the HTTP request.
- `@RequestMapping`: Used to map web requests to specific handler methods.
- `@GetMapping`: Shortcut for `@RequestMapping(method = RequestMethod.GET)`. It is used to handle HTTP GET requests.
- `@PostMapping`: Shortcut for `@RequestMapping(method = RequestMethod.POST)`. It is used to handle HTTP POST requests.
- `@PutMapping`: Shortcut for `@RequestMapping(method = RequestMethod.PUT)`. It is used to handle HTTP PUT requests.
- `@DeleteMapping`: Shortcut for `@RequestMapping(method = RequestMethod.DELETE)`. It is used to handle HTTP DELETE requests.

## Fixing pom.xml Version Setting Issues
If you encounter issues with version settings in `pom.xml` after initializing the project:
1. Go to IntelliJ IDEA Preferences: `Build, Execution, Deployment > Build Tools > Maven`.
2. Check the "Use plugin registry" checkbox and click "OK".
3. Navigate to `File > Invalidate Caches / Restart` to reload IntelliJ IDEA. This should resolve the issue automatically.

## Controller Layer
The Controller layer manages the web-based part of an application, handling HTTP requests. This layer processes incoming HTTP requests, directs them to appropriate service layers, and generates HTTP responses. Controllers in Spring Boot typically follow the MVC (Model-View-Controller) design pattern.

### `@Controller` vs `@RestController`
- `@Controller`: Indicates that the class is a controller that can return views (e.g., HTML pages).
- `@RestController`: Combines `@Controller` and `@ResponseBody`, indicating that the class is a controller where methods return data (e.g., JSON or XML) rather than views.

### `@RequestMapping`
This annotation maps HTTP requests to handler methods. It can specify the request type (GET, POST, PUT, DELETE, etc.) and the URL path for the request.

### Path Variables
Path variables are used to capture variable values from the URL path.

**Example:**
```java
@RestController
public class SampleController {

    @RequestMapping("/message")
    public String getMessage(@RequestParam String text) {
        return "Received Message: " + text;
    }
}
```

## Connecting to MySQL
To connect your Spring Boot application to a MySQL database, include the following dependency in your `pom.xml`:
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

## `@Entity` Annotation
The `@Entity` annotation is used to mark Java classes as database entities. It signifies that a class is a JPA (Java Persistence API) entity.

**Example:**
```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String email;

    // Getter and Setter methods
}
```
In this example, the `User` class is annotated with `@Entity`, indicating that it represents a database table. The `@Id` annotation specifies that the `id` field is the primary key of the table. The `username` and `email` fields correspond to columns in the database table.




# Spring Boot Annotations Guide

Spring Boot is a framework that simplifies Java application development with a set of annotations. This guide covers essential Spring Boot annotations, explaining their usage with examples.

## 1. `@SpringBootApplication`

`@SpringBootApplication` is the main entry point of a Spring Boot application. It combines three annotations:

- `@Configuration`: Indicates that the class is a configuration class.
- `@EnableAutoConfiguration`: Enables Spring Boot’s auto-configuration feature.
- `@ComponentScan`: Initiates component scanning to find Spring components like services and repositories.

### Example Code:
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
```

## 2. `@RestController`

`@RestController` marks a class as a RESTful web service controller. It combines `@Controller` and `@ResponseBody` annotations, meaning that the returned objects are automatically serialized into JSON or XML.

### Example Code:
```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

## 3. `@Service`

`@Service` denotes a class as a service component in the business logic layer. It is a specialization of the `@Component` annotation.

### Example Code:
```java
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public String process() {
        return "Processing...";
    }
}
```

## 4. `@Repository`

`@Repository` indicates that a class is a data access component. It provides additional functionality to handle database-specific exceptions.

### Example Code:
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {

    // Define data access methods here
}
```

## 5. `@Component`

`@Component` is a generic stereotype for any Spring-managed component. It is the base annotation for other specialized annotations like `@Service`, `@Repository`, and `@Controller`.

### Example Code:
```java
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    public String getInfo() {
        return "Component Info";
    }
}
```

## 6. `@Autowired`

`@Autowired` enables automatic dependency injection. Spring automatically resolves and injects the dependencies marked with this annotation.

### Example Code:
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public String process() {
        return "Processing...";
    }
}
```

## 7. `@Configuration`

`@Configuration` indicates that a class contains one or more `@Bean` methods, which are used to define beans that should be managed by the Spring container.

### Example Code:
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

## 8. `@Bean`

`@Bean` defines a method that returns an object to be managed by the Spring container. This annotation is used to create beans from Java configuration classes.

### Example Code:
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

## 9. `@Value`

`@Value` injects values into fields from configuration files or environment variables. It is often used to inject property values from `application.properties` or `application.yml`.

### Example Code:
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {

    @Value("${app.name}")
    private String appName;

    public String getAppName() {
        return appName;
    }
}
```

## 10. `@RequestMapping`

`@RequestMapping` is used to map web requests to specific handler methods. It can be used at the class or method level to define URL patterns and request methods (GET, POST, etc.).

### Example Code:
```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String greet() {
        return "Greetings!";
    }
}
```


