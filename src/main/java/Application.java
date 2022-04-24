import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
/*
Spring is all about removing configuration code from you application
    Why is configuration code such a bad thing in you app?
    -It makes things brittle. hard to move to different environments
    -It makes testing hard

    *Java configuration in Spring approach
    *Annotations in Spring
    *XML Configuration method

    instance of a factory or an abstact factory could be applied to creating new Speaker Service obj
    Spring does these things for us

 */
    /*
    - Constructor Injection -
    Just like setter Injection. Instead Of calling a setter we call a defined consturctor.
     */
    /*
    Prototype design pattern guarantees a unique instance per request.
    And, thus, scope inside of a Spring container mimics that design pattern
    Each time you request a bean from the container, you're guaranteed a unique instance
    It is essentially the opposite of a singleton.
     */

    /*
    STEREOTYPES ANNOTATIONS - to fully autowire
    @Component -> same thing as @Bean
    @Repository -> used to denote a class that's being used as a repository object
    @Service -> Service is neighter a microservice nor a webservice. it rather means where you would put your business logic
    @Controller -> Spring MVC
     */
    public static void main(String[] args) {
        ApplicationContext appCntext = new AnnotationConfigApplicationContext(AppConfig.class);
//        SpeakerService service = new SpeakerServiceImpl();
        SpeakerService service = appCntext.getBean("speakerService", SpeakerService.class);

//        System.out.println(service);
        System.out.println(service.findAll().get(0).getFirstName());
        System.out.println(service.findAll().get(0).getSeedNum());

        //Created another obj to show off singleton
//        SpeakerService service2 = appCntext.getBean("speakerService", SpeakerService.class);

//        System.out.println(service2);
        //same result because of the singleton

    }

}
