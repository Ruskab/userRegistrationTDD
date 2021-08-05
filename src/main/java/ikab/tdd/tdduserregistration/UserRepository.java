package ikab.tdd.tdduserregistration;

public interface UserRepository {
    User findBy(String id);

    void save(User user);
}
