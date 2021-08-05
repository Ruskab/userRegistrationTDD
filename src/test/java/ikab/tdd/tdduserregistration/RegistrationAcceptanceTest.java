package ikab.tdd.tdduserregistration;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistrationAcceptanceTest {

    private UserRepository repository;
    private MailService mailService;
    private IdGenerator idGenerator;

    @Test
    public void register_new_user() {
        var user = User.of("id", "name", "password");
        RegistrationService registrationService = new RegistrationService(repository, idGenerator);

        registrationService.createUser("name", "password");

        var persistedUser = repository.findBy("id");
        assertThat(persistedUser, is(user));
    }

}
