package ikab.tdd.tdduserregistration;

public class RegistrationService {

    private UserRepository userRepository;
    private IdGenerator idGenerator;

    public RegistrationService(UserRepository userRepository, IdGenerator idGenerator) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }

    public void createUser(String name, String password) {
        var uniqueId = idGenerator.generateId();
        userRepository.save(User.of(uniqueId, name, password));
    }
}
