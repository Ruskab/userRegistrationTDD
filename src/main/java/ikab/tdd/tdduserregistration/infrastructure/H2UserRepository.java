package ikab.tdd.tdduserregistration.infrastructure;

import ikab.tdd.tdduserregistration.domain.User;
import ikab.tdd.tdduserregistration.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class H2UserRepository implements UserRepository {


    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public User findBy(String id) {
        return userJpaRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        userJpaRepository.save(user);
    }

    @Override
    public Optional<User> getByName(String name) {
        return userJpaRepository.findAll().stream().filter(user -> user.getName().equals(name)).findFirst();
    }
}
