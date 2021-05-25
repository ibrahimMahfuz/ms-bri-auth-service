package id.co.pcsindonesia.ea.bri.authservice.app.service;

import id.co.pcsindonesia.ea.bri.authservice.app.http.response.GlobalResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.model.ForgotPasswordQuestion;
import id.co.pcsindonesia.ea.bri.authservice.app.repository.ForgotPasswordQuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ForgotPasswordQuestionService {

    private final ForgotPasswordQuestionRepository repository;
    private final PasswordEncoder passwordEncoder;

    public GlobalResponse<List<ForgotPasswordQuestion>> getAllQuestions(){
        return new GlobalResponse<>(200, "success get question data", repository.findAll());
    }

}
