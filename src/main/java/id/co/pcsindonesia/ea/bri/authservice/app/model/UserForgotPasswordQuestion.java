package id.co.pcsindonesia.ea.bri.authservice.app.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "user_forgot_password_questions")
public class UserForgotPasswordQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "forgot_password_question_id")
    private ForgotPasswordQuestion forgotPasswordQuestion;
}
