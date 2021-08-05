package ikab.tdd.tdduserregistration;

import ikab.tdd.tdduserregistration.fake.FakeIdGenerator;
import ikab.tdd.tdduserregistration.fake.FakeMailService;
import ikab.tdd.tdduserregistration.fake.FakeUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistrationAcceptanceTest {

    private UserRepository repository;
    private MailService mailService;
    private IdGenerator idGenerator;
    private RegistrationService registrationService;

    @BeforeEach
    void setUp() {
        idGenerator = new FakeIdGenerator();
        repository = new FakeUserRepository();
        mailService = new FakeMailService();
        registrationService = new RegistrationService(repository, idGenerator, mailService);
    }

    @Test
    public void register_new_user() {
        var user = User.of(idGenerator.generatedId(), "name", "password");

        registrationService.createUser("name", "password");

        var persistedUser = repository.findBy(idGenerator.generatedId());
        assertThat(persistedUser, is(user));
    }

}
