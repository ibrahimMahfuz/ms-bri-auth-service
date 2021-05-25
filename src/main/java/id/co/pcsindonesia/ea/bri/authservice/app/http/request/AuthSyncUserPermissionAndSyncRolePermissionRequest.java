package id.co.pcsindonesia.ea.bri.authservice.app.http.request;

import lombok.Data;

import java.util.List;

@Data
public class AuthSyncUserPermissionAndSyncRolePermissionRequest {
    private List<Long> permissionId;
}
