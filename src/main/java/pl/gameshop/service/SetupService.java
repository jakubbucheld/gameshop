package pl.gameshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.gameshop.service.registration.DefaultRegistrationService;
import pl.gameshop.service.registration.RegistrationData;

@Service
@Profile("heroku")  //  dla normalnej konfo=iguracji nie działą ta klasa, uruchamiana jest tylko przy konfigu Heroku
@RequiredArgsConstructor
public class SetupService implements CommandLineRunner
{
    private final DefaultRegistrationService defaultRegistrationService;


    @Override
    public void run(String... args) throws Exception
    {
        RegistrationData registrationData = new RegistrationData();
        registrationData.setUsername("trialUser");
        registrationData.setEmail("sample@email.com");
        registrationData.setPassword("abcdefgh");
        defaultRegistrationService.registration(registrationData);

    }
}
