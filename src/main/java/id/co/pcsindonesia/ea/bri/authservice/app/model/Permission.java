package id.co.pcsindonesia.ea.bri.authservice.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "permission")
    private Set<UserPermission> users;

    @JsonIgnore
    @OneToMany(mappedBy = "permission")
    private Set<RolePermission> roles;
}
