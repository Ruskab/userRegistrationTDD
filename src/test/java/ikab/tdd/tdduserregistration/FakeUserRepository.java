package ikab.tdd.tdduserregistration;

public class FakeUserRepository implements UserRepository {
    @Override
    public User findBy(String id) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
