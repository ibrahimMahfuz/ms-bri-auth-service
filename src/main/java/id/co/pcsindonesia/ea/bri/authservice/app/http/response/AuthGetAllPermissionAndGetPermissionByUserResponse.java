package id.co.pcsindonesia.ea.bri.authservice.app.http.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthGetAllPermissionAndGetPermissionByUserResponse {
    private Long id;
    private String name;
}
