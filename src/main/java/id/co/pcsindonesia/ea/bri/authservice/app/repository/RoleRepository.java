package id.co.pcsindonesia.ea.bri.authservice.app.repository;

import id.co.pcsindonesia.ea.bri.authservice.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
