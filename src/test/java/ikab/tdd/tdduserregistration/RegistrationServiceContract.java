package ikab.tdd.tdduserregistration;

import ikab.tdd.tdduserregistration.domain.RegistrationService;
import ikab.tdd.tdduserregistration.domain.User;
import ikab.tdd.tdduserregistration.exceptions.AlreadyExistentUserException;
import ikab.tdd.tdduserregistration.exceptions.MissingRequiredDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class RegistrationServiceContract {
    @Test
    public void createUser() {
        registrationService().createUser("name", "password");
    }

    @Test
    public void createUser_given_missing_data_should_throw_exception() {
        assertThrows(MissingRequiredDataException.class, () -> registrationService().createUser("", "password"));
    }

    @Test
    public void createUser_given_already_existent_user_with_that_name_should_throw_exception() {
        User existentUser = User.of("anyId", "name", "password");
        assertThrows(AlreadyExistentUserException.class, () -> registrationServiceWith(existentUser).createUser("name", "password"));
    }

    protected abstract RegistrationService registrationServiceWith(User user);

    protected abstract RegistrationService registrationService();
}
