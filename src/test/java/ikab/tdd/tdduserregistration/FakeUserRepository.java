package ikab.tdd.tdduserregistration;

public class FakeUserRepository implements UserRepository {
    private User user;

    @Override
    public User findBy(String id) {
        return User.copy(user);
    }

    @Override
    public void save(User user) {
        this.user = user;
    }
}
