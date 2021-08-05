package ikab.tdd.tdduserregistration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RegistrationAcceptanceTest {

    private UserRepository repository;
    private MailService mailService;

    @Test
    public void register_new_user() {
        var user = User.of("id", "name", "password");
        RegistrationService registrationService = new RegistrationService();

        registrationService.createUser("name", "password");

        var persistedUser = repository.findBy("id");
        assertThat(persistedUser, is(persistedUser));

    }

}
