package pl.coderslab.charity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
