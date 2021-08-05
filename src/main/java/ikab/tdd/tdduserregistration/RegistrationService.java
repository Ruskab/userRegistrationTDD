package ikab.tdd.tdduserregistration;

import ikab.tdd.tdduserregistration.exceptions.MissingRequiredDataException;

public class RegistrationService {

    private UserRepository userRepository;
    private IdGenerator idGenerator;

    public RegistrationService(UserRepository userRepository, IdGenerator idGenerator) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }

    public void createUser(String name, String password) {
        if (name.isBlank() || password.isBlank()) {
            throw new MissingRequiredDataException("name or password is missign");
        }
        var uniqueId = idGenerator.generateId();
        userRepository.save(User.of(uniqueId, name, password));
    }
}
