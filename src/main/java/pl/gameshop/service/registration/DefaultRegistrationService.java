package pl.gameshop.service.registration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gameshop.domain.model.User;
import pl.gameshop.domain.repository.UserRepository;
import pl.gameshop.security.Roles;
import pl.gameshop.service.RegistrationService;

@Service @Slf4j
public class DefaultRegistrationService implements RegistrationService
{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DefaultRegistrationService(UserRepository userRepository,
                                        PasswordEncoder passwordEncoder)
    {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void registration(RegistrationData registrationData)
    {
        log.debug("Dane do rejestracji: {}", registrationData);
        User user = new User();
        user.setUsername(registrationData.getUsername());
        user.setEmail(registrationData.getEmail());
        user.setPassword(passwordEncoder.encode(registrationData.getPassword()));
        user.getRoles().add(Roles.ROLE_USER.name());
        user.setActive(true);

        log.debug("Użytkownik do zapisania: {}", user);
        userRepository.save(user);
        log.debug("Zapisany użytkownik: {}", user);
    }
}
