package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gameshop.domain.model.Publisher;
import pl.gameshop.domain.repository.PublisherRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/publishers") @RequiredArgsConstructor
public class PublisherController
{
    public static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final PublisherRepository publisherRepository;

    @GetMapping({"/", "/all"})
    public String getAllPublishers(Model model)
    {
        model.addAttribute("publishers", publisherRepository.findAll());
        return "/publishers/all";
    }

    @GetMapping("/add")
    public String prepareAddPublisher(Model model)
    {
        model.addAttribute("publisher", new Publisher());
        return "/publishers/add";
    }

    @PostMapping("/add")
    public String processAddPublisher(@Valid Publisher publisher,
                                      BindingResult bindingResult)
    {
        log.info("Obiekt publisher do zapisu :: {}", publisher);
        if (bindingResult.hasErrors())
        {
            log.warn("Błąd podczas zapisu");
            return "/publishers/add";
        }
        log.info("Zapisany publisher :: {}", publisher);
        publisherRepository.save(publisher);
        return "redirect:/publishers/all";
    }
}
