package id.co.pcsindonesia.ea.bri.authservice.app.repository;

import id.co.pcsindonesia.ea.bri.authservice.app.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}