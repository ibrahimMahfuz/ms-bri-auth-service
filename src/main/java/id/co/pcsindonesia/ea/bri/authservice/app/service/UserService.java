package id.co.pcsindonesia.ea.bri.authservice.app.service;

import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthRegisterRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.AuthRegisterLoginResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.GlobalResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.TestResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Permission;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Role;
import id.co.pcsindonesia.ea.bri.authservice.app.model.User;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.UserRepository;
import id.co.pcsindonesia.ea.bri.authservice.configure.JwtConfiguration;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfiguration jwtConfiguration;

    @Transactional
    public GlobalResponse<AuthRegisterLoginResponse> createNewUser(AuthRegisterRequest authRegisterRequest) {
        User user = userRepository.save(User.builder()
                .username(authRegisterRequest.getUsername())
                .password(passwordEncoder.encode(authRegisterRequest.getPassword()))
                .storeId(1)
                .build());

        String responseToken = "Bearer " + Jwts.builder()
                .setSubject(user.getUsername())
                .claim("authorities", Collections.emptyMap())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfiguration.getTokenExpirationAfterDays())))
                .signWith(Keys.hmacShaKeyFor(jwtConfiguration.getSecret().getBytes(StandardCharsets.UTF_8)))
                .compact();

        return new GlobalResponse<>(
                200,
                "Success",
                new AuthRegisterLoginResponse(responseToken)
        );
    }

    public List<TestResponse> getAllUser() {
        return userRepository.findAll().stream()
                .map(user -> {
                    TestResponse testResponse = new TestResponse();
                    testResponse.setPermissions(
                            user.getPermissions().stream().map(Permission::getName).collect(Collectors.toList())
                    );
                    return testResponse;
                })
                .collect(Collectors.toList());
    }

    public List<Role> getRoleById(Long userId) {
        return new ArrayList<>(userRepository.findById(userId).orElseThrow().getRoles());
    }
}
