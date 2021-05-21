package id.co.pcsindonesia.ea.bri.authservice.app.http.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AuthRegisterLoginResponse {
    private String token;

    @Override
    public String toString() {
        return "{" +
                "token :'" + token + '\'' +
                '}';
    }
}
