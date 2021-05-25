package id.co.pcsindonesia.ea.bri.authservice.app.service;

import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthCreateNewRoleRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthSyncUserPermissionAndSyncRolePermissionRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.AuthGetAllRoleAndGetRoleByUserResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.GlobalResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Role;
import id.co.pcsindonesia.ea.bri.authservice.app.model.RolePermission;
import id.co.pcsindonesia.ea.bri.authservice.app.model.User;
import id.co.pcsindonesia.ea.bri.authservice.app.model.UserPermission;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.PermissionRepository;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.RolePermissionRepository;
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
    private final RolePermissionRepository rolePermissionRepository;
    private final PermissionRepository permissionRepository;

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

    @Transactional
    public GlobalResponse<String> syncRolePermission(AuthSyncUserPermissionAndSyncRolePermissionRequest request, Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow();
        rolePermissionRepository.deleteRolePermissionByRole(role);
        request.getPermissionId().forEach(aLong -> {
            permissionRepository.findById(aLong).ifPresent(permission -> {
                RolePermission rolePermission = RolePermission.builder().role(role).permission(permission)
                        .build();
                rolePermissionRepository.save(rolePermission);
            });
        });

        return new GlobalResponse<>(201, "role permission syncronized.", null);
    }
}
