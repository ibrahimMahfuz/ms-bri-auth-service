package id.co.pcsindonesia.ea.bri.authservice.app.http.controller;

import id.co.pcsindonesia.ea.bri.authservice.app.http.response.TestResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final UserService userService;

    @GetMapping
    public List<TestResponse> test(){
        return userService.getAllUser();
    }
}
