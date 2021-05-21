package id.co.pcsindonesia.ea.bri.authservice.app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "forgot_password_questions")
public class ForgotPasswordQuestion {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String Question;

}
