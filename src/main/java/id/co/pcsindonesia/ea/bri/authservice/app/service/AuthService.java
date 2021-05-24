package id.co.pcsindonesia.ea.bri.authservice.app.service;

import id.co.pcsindonesia.ea.bri.authservice.app.model.Auth;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Permission;
import id.co.pcsindonesia.ea.bri.authservice.app.model.User;
import id.co.pcsindonesia.ea.bri.authservice.app.model.UserPermission;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s).orElseThrow();
        Hibernate.initialize(user.getPermissions());
        Set<UserPermission> permissionSet = user.getPermissions();
        Set<SimpleGrantedAuthority> grantedAuthorities = permissionSet
        .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission().getName()))
                .collect(Collectors.toSet());
        return Auth.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .grantedAuthorities(
                        grantedAuthorities
                )
                .isCredentialsNonExpired(true)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isAccountNonLocked(true)
                 .build();
    }
}
