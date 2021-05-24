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
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    @Column(name = "store_id")
    private Integer storeId;

    @OneToMany(mappedBy = "user")
    private Set<UserPermission> permissions;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> roles;

}
