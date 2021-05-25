package id.co.pcsindonesia.ea.bri.authservice.app.repository;

import id.co.pcsindonesia.ea.bri.authservice.app.model.ForgotPasswordQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ForgotPasswordQuestionRepository extends JpaRepository<ForgotPasswordQuestion, Long> {
}
