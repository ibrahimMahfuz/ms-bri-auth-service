package id.co.pcsindonesia.ea.bri.authservice.app.http.request;

import lombok.Data;

import java.util.List;

@Data
public class AuthSyncUserRoleRequest {
    private List<Long> roleId;
}
