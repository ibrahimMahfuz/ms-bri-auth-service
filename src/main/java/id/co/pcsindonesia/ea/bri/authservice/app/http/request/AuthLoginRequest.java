package id.co.pcsindonesia.ea.bri.authservice.app.http.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AuthLoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 8)
    private String password;
}
