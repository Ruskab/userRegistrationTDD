package ikab.tdd.tdduserregistration;

import java.util.Optional;

public interface UserRepository {
    User findBy(String id);

    void save(User user);

    Optional<User> getByName(String name);
}
