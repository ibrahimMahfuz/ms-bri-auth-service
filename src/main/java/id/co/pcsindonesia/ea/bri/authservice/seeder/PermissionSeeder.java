package id.co.pcsindonesia.ea.bri.authservice.seeder;

import id.co.pcsindonesia.ea.bri.authservice.app.model.Permission;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PermissionSeeder {

    private final PermissionRepository permissionRepository;

    public void addAllPermission(){
        List<Permission> permissions = new ArrayList<>();

        permissions.add(
                Permission.builder()
                        .id(1L)
                        .name("user:read")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(2L)
                        .name("user:write")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(3L)
                        .name("role:read")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(4L)
                        .name("role:write")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(5L)
                        .name("permission:read")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(6L)
                        .name("user-role:read")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(7L)
                        .name("user-role:write")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(8L)
                        .name("user-permission:read")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(9L)
                        .name("user-permission:write")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(10L)
                        .name("role-permission:read")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .id(11L)
                        .name("role-permission:write")
                        .build()
        );
        permissionRepository.saveAll(permissions);
    }

}
