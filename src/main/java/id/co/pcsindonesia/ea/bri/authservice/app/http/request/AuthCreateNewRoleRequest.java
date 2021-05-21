package id.co.pcsindonesia.ea.bri.authservice.app.http.request;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@OpenAPIDefinition
@Data
public class AuthCreateNewRoleRequest {

    @NotNull
    @NotBlank
    private String name;
}
