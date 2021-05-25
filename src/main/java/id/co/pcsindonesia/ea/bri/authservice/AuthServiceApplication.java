package id.co.pcsindonesia.ea.bri.authservice;

import id.co.pcsindonesia.ea.bri.authservice.seeder.PermissionSeeder;
import id.co.pcsindonesia.ea.bri.authservice.seeder.RoleSeeder;
import id.co.pcsindonesia.ea.bri.authservice.seeder.UserSeeder;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ConfigurationPropertiesScan
@OpenAPIDefinition
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@AllArgsConstructor
public class AuthServiceApplication {

    private final UserSeeder userSeeder;
    private final RoleSeeder roleSeeder;
    private final PermissionSeeder permissionSeeder;

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        userSeeder.addAdmin();
        roleSeeder.addAdminRole();
        permissionSeeder.addAllPermission();
        userSeeder.syncUserRole();
        roleSeeder.addAdminPermission();
    }
}
