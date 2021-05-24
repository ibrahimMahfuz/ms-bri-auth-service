package id.co.pcsindonesia.ea.bri.authservice.app.service;

import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthCreateNewRoleRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.AuthGetAllRoleAndGetRoleByUserResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Role;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<AuthGetAllRoleAndGetRoleByUserResponse> getAllRole(){
        return roleRepository.findAll().stream()
                .map(role -> {
                    return new AuthGetAllRoleAndGetRoleByUserResponse(role.getId(), role.getName());
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public Role createNewRole(AuthCreateNewRoleRequest authCreateNewRoleRequest) {
        Role role = roleRepository.save(
                Role.builder()
                .name(authCreateNewRoleRequest.getName())
                .build()
        );

        return role;
    }

}
