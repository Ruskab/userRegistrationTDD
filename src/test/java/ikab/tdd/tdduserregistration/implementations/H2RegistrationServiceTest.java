package ikab.tdd.tdduserregistration.implementations;

import ikab.tdd.tdduserregistration.RegistrationServiceContract;
import ikab.tdd.tdduserregistration.domain.RegistrationService;
import ikab.tdd.tdduserregistration.domain.User;
import ikab.tdd.tdduserregistration.infrastructure.H2UserRepository;
import ikab.tdd.tdduserregistration.infrastructure.RealIdGenerator;
import ikab.tdd.tdduserregistration.infrastructure.RealMailService;
import ikab.tdd.tdduserregistration.infrastructure.UserJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class H2RegistrationServiceTest extends RegistrationServiceContract {

    @Autowired
    private H2UserRepository repository;
    @Autowired
    private UserJpaRepository jpaRepository;
    @Autowired
    private RealIdGenerator idGenerator;
    @Autowired
    private RealMailService mailService;
    private RegistrationService registrationService;

    @BeforeEach
    void setUp() {
        registrationService = new RegistrationService(repository, idGenerator, mailService);
    }

    @Override
    protected RegistrationService registrationServiceWith(User user) {
        repository.save(user);
        return registrationService;
    }

    @Override
    protected RegistrationService registrationService() {
        jpaRepository.deleteAll();
        return registrationService;
    }
}
