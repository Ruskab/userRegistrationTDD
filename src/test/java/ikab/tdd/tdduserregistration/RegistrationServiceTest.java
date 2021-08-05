package ikab.tdd.tdduserregistration;

import ikab.tdd.tdduserregistration.domain.IdGenerator;
import ikab.tdd.tdduserregistration.domain.MailService;
import ikab.tdd.tdduserregistration.domain.RegistrationService;
import ikab.tdd.tdduserregistration.domain.User;
import ikab.tdd.tdduserregistration.domain.UserRepository;
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
    private MailService mailService;
    private RegistrationService registrationService;

    @BeforeEach
    void setUp() {
        repository = mock(UserRepository.class);
        idGenerator = mock(IdGenerator.class);
        mailService = mock(MailService.class);
        doReturn(UNIQUE_ID).when(idGenerator).generatedId();
        registrationService = new RegistrationService(repository, idGenerator, mailService);
    }

    @Test
    void createUser_should_persiste_user_with_randomly_generated_id_and_send_mail() {
        User user = User.of(UNIQUE_ID, "name", "password");

        registrationService.createUser("name", "password");

        verify(idGenerator, times(1)).generatedId();
        verify(repository, times(1)).save(user);
        verify(mailService, times(1)).sendWelcomeMail(user);
    }

    @Test
    public void createUser_should_not_persiste_user_without_all_required_data_and_throw_exception() {
        assertThrows(MissingRequiredDataException.class, () -> registrationService.createUser("", ""));
        verify(idGenerator, times(0)).generatedId();
        verify(repository, times(0)).save(any());
        verify(mailService, times(0)).sendWelcomeMail(any());
    }
}
