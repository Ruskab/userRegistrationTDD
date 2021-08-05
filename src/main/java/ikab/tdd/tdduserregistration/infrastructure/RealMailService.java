package ikab.tdd.tdduserregistration.infrastructure;

import ikab.tdd.tdduserregistration.domain.MailService;
import ikab.tdd.tdduserregistration.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RealMailService implements MailService {

    @Override
    public void sendWelcomeMail(User user) {

    }
}
