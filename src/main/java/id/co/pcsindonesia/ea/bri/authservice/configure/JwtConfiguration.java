package id.co.pcsindonesia.ea.bri.authservice.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "appication.jwt.properties")
@Data
public class JwtConfiguration {
    private String secret;
    private Integer tokenExpirationAfterDays;
}
