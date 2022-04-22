import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//aplicationContect.xml replaced by @Configuration
//@Configuration at class level
//@Bean - used to get instances of Spring Beans - at method level
//SETTER INJECTION ; Simple as a method call

@Configuration
public class AppConfig {

    //changing the scope will change the pattern
    @Bean(name = "speakerService")
    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
//    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public SpeakerService getSpeakerService() {
//        return new SpeakerServiceImpl();
        SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
//        service.setRepository(getSpeakerRepository());
        return service;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {

        return new HibernateSpeakerRepositoryImpl();

    }

}
