package ikab.tdd.tdduserregistration.fake;

import ikab.tdd.tdduserregistration.User;
import ikab.tdd.tdduserregistration.UserRepository;

import java.util.Optional;

public class FakeUserRepository implements UserRepository {
    private User user;

    public FakeUserRepository(User user) {
        this.user = user;
    }

    public FakeUserRepository() {

    }

    @Override
    public User findBy(String id) {
        return User.copy(user);
    }

    @Override
    public void save(User user) {
        this.user = user;
    }

    @Override
    public Optional<User> getByName(String name) {
        if (user == null) {
            return Optional.empty();
        }
        if (this.user.getName().equals(name)) {
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
