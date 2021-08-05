package ikab.tdd.tdduserregistration.domain;

import ikab.tdd.tdduserregistration.exceptions.AlreadyExistentUserException;
import ikab.tdd.tdduserregistration.exceptions.MissingRequiredDataException;


public class RegistrationService {

    private UserRepository userRepository;
    private IdGenerator idGenerator;
    private MailService mailService;

    public RegistrationService(UserRepository userRepository, IdGenerator idGenerator, MailService mailService) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
        this.mailService = mailService;
    }

    public void createUser(String name, String password) {
        if (name.isBlank() || password.isBlank()) {
            throw new MissingRequiredDataException("name or password is missign");
        }
        if (userRepository.getByName(name).isPresent()) {
            throw new AlreadyExistentUserException("User with name " + name + "already exists");
        }
        var uniqueId = idGenerator.generatedId();
        User user = User.of(uniqueId, name, password);
        userRepository.save(user);
        mailService.sendWelcomeMail(user);
    }
}
