package pl.gameshop.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gameshop.service.RegistrationService;
import pl.gameshop.service.registration.RegistrationData;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration") @Slf4j /** */
public class RegistrationController
{
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model)
    {
        model.addAttribute("registrationData", new RegistrationData());
        return "/registration/form";
    }

    @PostMapping
    public String processRegistrationData(@Valid RegistrationData registrationData,
                                          BindingResult errors)
    {
        log.debug("Dane do rejestracji: {}", errors);
        if(errors.hasErrors())
        {
            log.debug("Błędy w danych do rejestracji: {}", errors);
            return "/registration/form";
        }
        registrationService.registration(registrationData);
        log.debug("Poprawnie zarejestrowano dane: {}", registrationData);
        return "/registration/success";
    }
}
