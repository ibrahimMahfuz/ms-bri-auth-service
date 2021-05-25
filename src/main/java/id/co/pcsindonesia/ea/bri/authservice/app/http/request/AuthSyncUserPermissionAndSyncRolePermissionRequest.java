package id.co.pcsindonesia.ea.bri.authservice.app.http.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthSyncUserPermissionAndSyncRolePermissionRequest {
    private List<Long> permissionId;
}
