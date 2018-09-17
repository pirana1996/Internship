package mk.finki.emt.phoneshop.repository.jpa;

import mk.finki.emt.phoneshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
