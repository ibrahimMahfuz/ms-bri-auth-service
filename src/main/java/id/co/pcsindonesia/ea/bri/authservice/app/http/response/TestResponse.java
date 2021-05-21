package id.co.pcsindonesia.ea.bri.authservice.app.http.response;

import lombok.Data;

import java.util.List;

@Data
public class TestResponse {
    private Integer id;
    private String username;
    private List<String> permissions;

}
