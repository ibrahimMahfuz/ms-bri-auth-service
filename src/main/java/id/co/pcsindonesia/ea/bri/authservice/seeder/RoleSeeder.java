package id.co.pcsindonesia.ea.bri.authservice.seeder;

import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthCreateNewRoleRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthSyncUserPermissionAndSyncRolePermissionRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Role;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.RoleRepository;
import id.co.pcsindonesia.ea.bri.authservice.app.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RoleSeeder {

    private final RoleService roleService;
    private final RoleRepository roleRepository;

    public void addAdminRole(){
        roleRepository.save(Role.builder()
                .id(1L)
                .name("admin")
                .build());
    }

    public void addAdminPermission(){
        roleService.syncRolePermission(
                AuthSyncUserPermissionAndSyncRolePermissionRequest.builder().permissionId(List.of(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L)).build(), 1L
        );
    }

}
