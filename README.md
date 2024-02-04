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
**Controller Layers:**
<br />
bir uygulamanın web tabanlı kısmını yöneten ve HTTP isteklerine cevap veren bir katmandır. Bu katman, gelen HTTP isteklerini alır, işler, uygun servis katmanlarına yönlendirir ve sonunda HTTP cevaplarını oluşturur. Spring Boot'taki controller'lar genellikle MVC (Model-View-Controller) tasarım desenine uyarlar.
<br />
**@Controller** veya **@RestController:** Bu anotasyonlar, sınıfın bir controller olduğunu belirtir. @Controller genel olarak HTML sayfaları gibi görüntüler üretirken, @RestController JSON veya XML gibi veri formatlarını üretmek üzere tasarlanmıştır.
<br />
**@RequestMapping:** Bu anotasyon, bir HTTP isteğinin hangi metodun çalıştırılacağını belirtir. İsteğin tipi (GET, POST, PUT, DELETE vb.) ve isteğin geldiği URL yolu bu anotasyon ile belirlenir.
<br />
**Path Variables:** Yol değişkenleri, URL'deki değişken değerleri almak için kullanılır.

```java
@RestController
public class SampleController {

    @RequestMapping("/mesaj")
    public String alMesaj(@RequestParam String metin) {
        return "Alınan Mesaj: " + metin;
    }
}

```



