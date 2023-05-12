package dev.abidino.scheduler.message.kafka;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Gson gson() {
        return new Gson();
    }

}
