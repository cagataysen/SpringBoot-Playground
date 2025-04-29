package config;

import beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public MyBean myBean() {
        MyBean b = new MyBean();
        b.setText("Hello");
        return b;
    }

}
