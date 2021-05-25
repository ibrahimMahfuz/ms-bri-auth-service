package id.co.pcsindonesia.ea.bri.authservice.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<RolePermission> permissions;

    @OneToMany(mappedBy = "role")
    private List<UserRole> users;
}
