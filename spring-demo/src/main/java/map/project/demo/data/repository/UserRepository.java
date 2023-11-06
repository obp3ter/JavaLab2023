package map.project.demo.data.repository;

import java.util.List;

import map.project.demo.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE u.name LIKE %?1%")
    List<User> findByNameContaining(String name);
}
