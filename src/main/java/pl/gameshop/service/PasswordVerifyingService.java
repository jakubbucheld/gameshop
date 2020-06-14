package pl.gameshop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gameshop.domain.model.User;
import pl.gameshop.domain.repository.UserRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor @Service @Slf4j
public class PasswordVerifyingService
{
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public boolean verify(User user,
                          String password)
    {
        return passwordEncoder.encode(password).equals(user.getPassword());
    }
}
