
# Understanding Spring Beans and Dependency Injection

### 1. Spring Beans and Objects

In the Spring Framework, **beans** are objects managed by the Spring container. They are instances of classes that can interact with each other, much like objects from other classes. These beans enable structured communication between different parts of an application through **Dependency Injection (DI)**.

Example:
```java
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```

### 2. UserRepository as a Bean

When `UserRepository` is annotated with `@Repository`, Spring registers it as a bean in the application context. The `UserService` class depends on this bean, and Spring injects it automatically using `@Autowired`.

Key Point:
- **Beans**: Objects managed by Spring.
- **Bean Wiring**: Linking one bean (e.g., `UserRepository`) to another bean (e.g., `UserService`).

### 3. Injected Objects in JSF and Spring

In **JSF (JavaServer Faces)**, `@Inject` is used for dependency injection, similar to Spring's `@Autowired`. Both serve the same purpose but are part of different frameworks.

Example in JSF:
```java
@Named
@SessionScoped
public class MyBean implements Serializable {
    @Inject
    private AnotherBean anotherBean;

    public void doSomething() {
        anotherBean.performAction();
    }
}
```

Example in Spring:
```java
@Service
public class MyService {
    @Autowired
    private AnotherService anotherService;

    public void doSomething() {
        anotherService.performAction();
    }
}
```

### 4. One Class and Multiple Beans

A single class can have multiple beans if you register different instances of that class in the Spring context. These beans might have distinct configurations.

Example:
```java
@Configuration
public class AppConfig {

    @Bean
    public MyService myServiceOne() {
        return new MyService("Instance One");
    }

    @Bean
    public MyService myServiceTwo() {
        return new MyService("Instance Two");
    }
}
```

Usage:
```java
@Autowired
@Qualifier("myServiceOne")
private MyService myService; // Injects the specific bean
```

### 5. Circular Dependency with Multiple Beans

If circular dependencies exist, you can use `@Qualifier` or `@Primary` to resolve ambiguity:

1. **Primary Bean**:
   ```java
   @Bean
   @Primary
   public NotificationService emailNotificationService() {
       return new NotificationService("Email");
   }
   ```

2. **Using Qualifier**:
   ```java
   @Autowired
   @Qualifier("smsNotificationService")
   private NotificationService smsService;
   ```

If `@Qualifier` is not specified, Spring will use the `@Primary` bean by default.

### 6. Examples of `@Qualifier` Usage

#### Basic Usage:
```java
@Autowired
@Qualifier("emailNotificationService")
private NotificationService notificationService;
```

#### Field Injection:
```java
@Autowired
@Qualifier("smsNotificationService")
private NotificationService smsService;
```

#### Constructor Injection:
```java
@Autowired
public NotificationManager(@Qualifier("emailNotificationService") NotificationService notificationService) {
    this.notificationService = notificationService;
}
```

#### Collections:
```java
@Autowired
private Map<String, NotificationService> notificationServices;
```

#### Custom Annotations:
```java
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface EmailService {
}
```

### Summary
- **`@Primary`**: Declares a default bean.
- **`@Qualifier`**: Specifies a particular bean explicitly.
- Multiple beans remain in the container even if unused, making them available for future injections.
