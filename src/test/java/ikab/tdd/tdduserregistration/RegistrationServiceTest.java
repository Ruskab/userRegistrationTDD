package ikab.tdd.tdduserregistration;

import ikab.tdd.tdduserregistration.exceptions.MissingRequiredDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RegistrationServiceTest {

    public static final String UNIQUE_ID = "1";
    private UserRepository repository;
    private IdGenerator idGenerator;

    @BeforeEach
    void setUp() {
        repository = mock(UserRepository.class);
        idGenerator = mock(IdGenerator.class);
        doReturn(UNIQUE_ID).when(idGenerator).generateId();
    }

    @Test
    void createUser_should_persiste_user_with_randomly_generated_id() {
        new RegistrationService(repository, idGenerator).createUser("name", "password");

        verify(idGenerator, times(1)).generateId();
        verify(repository, times(1)).save(User.of(UNIQUE_ID, "name", "password"));
    }

    @Test
    public void createUser_should_not_persiste_user_without_all_required_data_and_throw_exception() {
        assertThrows(MissingRequiredDataException.class, () -> new RegistrationService(repository, idGenerator).createUser("", ""));
        verify(idGenerator, times(0)).generateId();
        verify(repository, times(0)).save(any());
    }
}
