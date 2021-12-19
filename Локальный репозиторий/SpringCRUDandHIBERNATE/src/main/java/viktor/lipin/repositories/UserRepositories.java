package viktor.lipin.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viktor.lipin.model.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
}
