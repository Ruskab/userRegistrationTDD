package ikab.tdd.tdduserregistration;

import ikab.tdd.tdduserregistration.exceptions.MissingRequiredDataException;
import ikab.tdd.tdduserregistration.fake.FakeIdGenerator;
import ikab.tdd.tdduserregistration.fake.FakeMailService;
import ikab.tdd.tdduserregistration.fake.FakeUserRepository;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FakeRegistrationServiceContract {

    @Test
    public void createUser() {
        registrationService().createUser("name", "password");
    }

    @Test
    public void createUser_given_missing_data_should_throw_exception() {
        assertThrows(MissingRequiredDataException.class, () -> registrationService().createUser("", "password"));;
    }

    @Test
    public void createUser_given_already_existent_user_with_that_name_should_throw_exception() {
        User existentUser = User.of("name", "password");
        assertThrows(AlreadyExistentUserException.class, () -> registrationServiceWith(existentUser).createUser("name", "password"));
    }

    private RegistrationService registrationServiceWith(User user) {
        return new RegistrationService(new FakeUserRepository(user), new FakeIdGenerator(), new FakeMailService());
    }

    private RegistrationService registrationService() {
        return new RegistrationService(new FakeUserRepository(), new FakeIdGenerator(), new FakeMailService());
    }

}
