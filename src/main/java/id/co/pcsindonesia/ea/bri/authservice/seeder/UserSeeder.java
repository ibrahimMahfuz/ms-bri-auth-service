package id.co.pcsindonesia.ea.bri.authservice.seeder;

import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthRegisterRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthSyncUserRoleRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.model.User;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.UserRepository;
import id.co.pcsindonesia.ea.bri.authservice.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserSeeder {
    private final UserService userService;

    public void addAdmin(){
        userService.createNewUser(
                new AuthRegisterRequest("admin", "admin", 0)
        );
    }

    public void syncUserRole(){
        userService.syncUserRole(
                AuthSyncUserRoleRequest.builder().roleId(List.of(1L)).build(), 1L
        );
    }
}
