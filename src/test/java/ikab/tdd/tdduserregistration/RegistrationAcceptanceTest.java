package ikab.tdd.tdduserregistration;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RegistrationAcceptanceTest {

    @Test
    public void register_new_user() {
        registrationService.createUser("name", "password");

        verify(mailService, times(1)).sendWelcomeMail(user);
        var user = userRepository.findBy("id");
        assertThat(user, is(User.of("id", "name", "password")));

    }

}
