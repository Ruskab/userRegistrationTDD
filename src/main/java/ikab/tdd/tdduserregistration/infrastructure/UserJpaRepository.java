package ikab.tdd.tdduserregistration.infrastructure;

import ikab.tdd.tdduserregistration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, String> {
}
