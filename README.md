# SpringBoot-Playground
Personel Documentation of SpringBoot
<br />
@SpringBootApplication = @EnableAutoConfiguration + @ComponentScan + @Configuration
<br />
@RestController, 
<br />
@RequestBody, 
<br />
@RequestMapping, 
<br />
@GetMapping,  //getting-retrieving the data with url GET
<br />
@PostMapping,   //creating new data POST 
<br />
@PutMapping, 		//updating the data PUT
<br />
@DeleteMapping		//deleting the data DELETE
<br />
For pom.xml version setting problems after initiliazing the project:
<br />
From the Preferences in IntelliJ, navigate to "Build, Execution, Deployment > Build Tools > Maven", check the "Use plugin registry", and click "OK".
Then "File > Invalidate Caches / Restart" to reload Intelli J. The error will go away automatically.

<br />
<strong>  Controller Layers: </strong>
<br />
Bir uygulamanın web tabanlı kısmını yöneten ve HTTP isteklerine cevap veren bir katmandır. Bu katman, gelen HTTP isteklerini alır, işler, uygun servis katmanlarına yönlendirir ve sonunda HTTP cevaplarını oluşturur. Spring Boot'taki controller'lar genellikle MVC (Model-View-Controller) tasarım desenine uyarlar.
<br />
<strong>  @Controller veya @RestController:  </strong>
<br />
Bu anotasyonlar, sınıfın bir controller olduğunu belirtir. @Controller genel olarak HTML sayfaları gibi görüntüler üretirken, @RestController JSON veya XML gibi veri formatlarını üretmek üzere tasarlanmıştır.
<br />
<strong>  @RequestMapping: </strong>
<br />
Bu anotasyon, bir HTTP isteğinin hangi metodun çalıştırılacağını belirtir. İsteğin tipi (GET, POST, PUT, DELETE vb.) ve isteğin geldiği URL yolu bu anotasyon ile belirlenir.
<br />
<strong>  Path Variables: </strong>
Yol değişkenleri, URL'deki değişken değerleri almak için kullanılır.
<br />
Path Variables example: /mesaj is a path variable and its gonna be on the url:
<br />

```java
@RestController
public class SampleController {

    @RequestMapping("/mesaj")
    public String alMesaj(@RequestParam String metin) {
        return "Alınan Mesaj: " + metin;
    }
}

```
<strong> mySql has connected with the dependency of </strong>

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```
<br />
<br />
<strong>@Entity annotasyonu: <strong> <br />
Veritabanı tablolarını temsil eden Java sınıflarını işaretlemek için kullanılır. @Entity annotasyonu, sınıfın bir JPA (Java Persistence API) varlığı olduğunu belirtir.<br />

```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String email;
    
    // Getter ve setter metodları
}
```
User sınıfı @Entity annotasyonuyla işaretlenmiş ve bir JPA varlığı olarak belirtilmiştir. Bu sınıf, bir veritabanı tablosunu temsil eder. @Id annotasyonu, id alanının birincil anahtar (primary key) olduğunu belirtir. Diğer alanlar (username ve email) da sırasıyla veritabanı tablosundaki sütunları temsil eder.
<br />
<br />
<br />


