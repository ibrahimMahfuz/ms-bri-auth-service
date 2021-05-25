package id.co.pcsindonesia.ea.bri.authservice.app.repository;

import id.co.pcsindonesia.ea.bri.authservice.app.model.User;
import id.co.pcsindonesia.ea.bri.authservice.app.model.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
    void deleteUserPermissionByUser(User user);
}
