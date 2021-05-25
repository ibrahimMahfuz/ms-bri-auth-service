package id.co.pcsindonesia.ea.bri.authservice.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "forgot_password_questions")
public class ForgotPasswordQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String Question;

    @JsonIgnore
    @OneToMany(mappedBy = "forgotPasswordQuestion")
    private Set<UserForgotPasswordQuestion> userForgotPasswordQuestions;
}
