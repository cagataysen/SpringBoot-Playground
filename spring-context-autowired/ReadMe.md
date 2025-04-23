# context:

Without Spring context?

If you don't use Spring, this line:

```java
@Autowired
private ProductRepository productRepository;
```

means **nothing**.

Java doesn't know what `@Autowired` is supposed to do — it doesn't inject anything. So `productRepository` stays **null**, and when you call `productRepository.add()`, it crashes.


> With Spring context, `@Autowired` tells Spring:  
> “Please find this missing part and install it before I use the object.”  
> Spring listens and does it.

> Without context, Java sees the same request, but nobody is there to listen. So the part stays missing.


### 🧠 What Spring Does (Behind the Scenes):

- It scans the class and sees `@Service` on `ProductDeliveryService`.

-  It says:

   > “Okay! I need to make this class ready for use. Let me check inside it...”

- It finds this line:

```
@Autowired
private ProductRepository productRepository;
```

- Spring says:

  > “Aha! This class needs a `ProductRepository`. Let me go find it.”

- Spring looks around and sees that `ProductRepository` is marked with:
    ```
    @Repository public class ProductRepository { ... }
	```

- Spring says:

  > “Perfect, I already created one of those! I’ll **put it into the service** now.”

- Spring sets the `productRepository` variable **for you**, like this (but behind the scenes):
  ```
    this.productRepository = new ProductRepository();
    ```