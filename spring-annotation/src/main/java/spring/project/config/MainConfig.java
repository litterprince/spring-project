package spring.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.project.bean.Color;

@Configuration
@ComponentScan({"spring.project.bean"})
public class MainConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Color color(){
        System.out.println("create color ...");
        return new Color();
    }
}
