package id.co.pcsindonesia.ea.bri.authservice.app.http.response;

import id.co.pcsindonesia.ea.bri.authservice.app.model.ForgotPasswordQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GlobalResponse<T> {
    private Integer code;
    private String message;
    private T result;

    @Override
    public String toString() {
        return "{" +
                "code: " + code +
                ", message: '" + message + '\'' +
                ", result:" + result +
                '}';
    }
}
