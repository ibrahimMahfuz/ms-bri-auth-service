package id.co.pcsindonesia.ea.bri.authservice.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "forgot_password_questions")
public class ForgotPasswordQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String Question;

    @OneToMany(mappedBy = "forgotPasswordQuestion")
    private Set<UserForgotPasswordQuestion> userForgotPasswordQuestions;
}
