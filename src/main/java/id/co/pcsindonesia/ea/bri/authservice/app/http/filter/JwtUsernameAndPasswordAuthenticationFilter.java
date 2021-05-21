package id.co.pcsindonesia.ea.bri.authservice.app.http.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthLoginRequest;
import id.co.pcsindonesia.ea.bri.authservice.builder.AuthRegisterLoginResponseBuilder;
import id.co.pcsindonesia.ea.bri.authservice.configure.JwtConfiguration;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final ObjectMapper objectMapper;
    private final JwtConfiguration jwtConfiguration;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper, JwtConfiguration jwtConfiguration) {
        this.objectMapper = objectMapper;
        this.jwtConfiguration = jwtConfiguration;
        this.setFilterProcessesUrl("/auth/login");
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            AuthLoginRequest authenticationRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), AuthLoginRequest.class);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );

//            setDetails(request, authentication);

            return authenticationManager.authenticate(authentication);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("succeses");
        String responseToken = "Bearer " + Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfiguration.getTokenExpirationAfterDays())))
                .signWith(Keys.hmacShaKeyFor(jwtConfiguration.getSecret().getBytes(StandardCharsets.UTF_8)))
                .compact();

        AuthRegisterLoginResponseBuilder.getInstance(response, objectMapper)
                .addHeader("Authorization", responseToken)
                .setContentType("application/json")
                .setCharacterEncoding("UTF-8")
                .writeBody(200, "Login Successfully", responseToken)
        .build();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.info(failed.getMessage());
        super.unsuccessfulAuthentication(request, response, failed);
    }

}
