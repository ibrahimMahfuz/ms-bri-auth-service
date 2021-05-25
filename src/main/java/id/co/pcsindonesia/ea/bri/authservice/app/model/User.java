package id.co.pcsindonesia.ea.bri.authservice.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    @Column(name = "store_id")
    private Integer storeId;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<UserPermission> permissions;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<UserRole> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<UserForgotPasswordQuestion> userForgotPasswordQuestions;

}
