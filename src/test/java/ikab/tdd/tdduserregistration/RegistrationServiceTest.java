package ikab.tdd.tdduserregistration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RegistrationServiceTest {

    private UserRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(UserRepository.class);
    }

    @Test
    void createUser_should_persiste_user() {
        new RegistrationService().createUser("name", "password");

        verify(repository, times(1)).save(User.of("1", "name", "password"));
    }
}
