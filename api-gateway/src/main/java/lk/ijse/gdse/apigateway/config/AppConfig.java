package lk.ijse.gdse.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Amil Srinath
 */
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}
