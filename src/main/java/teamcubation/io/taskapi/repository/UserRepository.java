package teamcubation.io.taskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamcubation.io.taskapi.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
