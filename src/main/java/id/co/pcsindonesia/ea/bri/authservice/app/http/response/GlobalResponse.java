package id.co.pcsindonesia.ea.bri.authservice.app.http.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GlobalResponse<T> {
    private Integer code;
    private String message;
    private T data;

    @Override
    public String toString() {
        return "{" +
                "code: " + code +
                ", message: '" + message + '\'' +
                ", data:" + data +
                '}';
    }
}
