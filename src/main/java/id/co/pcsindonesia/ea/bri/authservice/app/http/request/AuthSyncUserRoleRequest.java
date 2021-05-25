package id.co.pcsindonesia.ea.bri.authservice.app.http.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class AuthSyncUserRoleRequest {

    @NotBlank
    private List<Long> roleId;
}
