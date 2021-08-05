package ikab.tdd.tdduserregistration.implementations;

import ikab.tdd.tdduserregistration.RegistrationServiceContract;
import ikab.tdd.tdduserregistration.domain.RegistrationService;
import ikab.tdd.tdduserregistration.domain.User;
import ikab.tdd.tdduserregistration.fake.FakeIdGenerator;
import ikab.tdd.tdduserregistration.fake.FakeMailService;
import ikab.tdd.tdduserregistration.fake.FakeUserRepository;

public class FakeRegistrationServiceTest extends RegistrationServiceContract {

    @Override
    protected RegistrationService registrationServiceWith(User user) {
        return new RegistrationService(new FakeUserRepository(user), new FakeIdGenerator(), new FakeMailService());
    }

    @Override
    protected RegistrationService registrationService() {
        return new RegistrationService(new FakeUserRepository(), new FakeIdGenerator(), new FakeMailService());
    }

}
