package id.co.pcsindonesia.ea.bri.authservice.app.service;

import id.co.pcsindonesia.ea.bri.authservice.app.http.response.AuthGetAllPermissionAndGetPermissionByUserResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Permission;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public List<AuthGetAllPermissionAndGetPermissionByUserResponse> getAllPermission(){
        return  permissionRepository.findAll().stream()
                .map(permission -> {
                    return new AuthGetAllPermissionAndGetPermissionByUserResponse(permission.getId(), permission.getName());
                })
                .collect(Collectors.toList());
    }
}
