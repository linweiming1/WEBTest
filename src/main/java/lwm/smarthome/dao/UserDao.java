package lwm.smarthome.dao;

import lwm.smarthome.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long> {
}