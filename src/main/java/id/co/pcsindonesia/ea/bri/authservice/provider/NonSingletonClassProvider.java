package id.co.pcsindonesia.ea.bri.authservice.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class NonSingletonClassProvider {

    @Bean
    @Scope("prototype")
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
