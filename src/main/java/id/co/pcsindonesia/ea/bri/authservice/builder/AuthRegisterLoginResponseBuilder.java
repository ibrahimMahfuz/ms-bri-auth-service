package id.co.pcsindonesia.ea.bri.authservice.builder;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.AuthRegisterLoginResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.GlobalResponse;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@AllArgsConstructor
public class AuthRegisterLoginResponseBuilder {

    private final HttpServletResponse response;
    private final ObjectMapper objectMapper;

    public static AuthRegisterLoginResponseBuilder getInstance(HttpServletResponse response, ObjectMapper objectMapper){
        return new AuthRegisterLoginResponseBuilder(response, objectMapper);
    }

    public AuthRegisterLoginResponseBuilder addHeader(String headerName, String headerValue){
        response.addHeader(headerName, headerValue);
        return this;
    }

    public AuthRegisterLoginResponseBuilder setContentType(String contentType){
        response.setContentType(contentType);
        return this;
    }

    public AuthRegisterLoginResponseBuilder setCharacterEncoding(String ce){
        response.setCharacterEncoding(ce);
        return this;
    }

    public AuthRegisterLoginResponseBuilder writeBody(Integer code, String message, String token) throws IOException {
        response.getWriter().write(objectMapper.writeValueAsString(new GlobalResponse<>(
                code,
                message,
                new AuthRegisterLoginResponse(
                        token
                )
        )));
        return this;
    }

    public HttpServletResponse build(){
        return response;
    }
}
