package spring.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import spring.project.bean.Person;

@PropertySource(value = "classpath:person.properties")
@Configuration
public class PropertiesConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
