package ikab.tdd.tdduserregistration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RegistrationServiceTest {

    private UserRepository repository;
    private IdGenerator idGenerator;

    @BeforeEach
    void setUp() {
        repository = mock(UserRepository.class);
    }

    @Test
    void createUser_should_persiste_user_with_randomly_generated_id() {
        new RegistrationService(repository).createUser("name", "password");

        verify(repository, times(1)).save(User.of("1", "name", "password"));
        verify(idGenerator, times(1)).generateId();
    }
}
