package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ManyToAny;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gameshop.domain.model.Category;
import pl.gameshop.domain.model.Game;
import pl.gameshop.domain.model.Publisher;
import pl.gameshop.domain.repository.CategoryRepository;
import pl.gameshop.domain.repository.GameRepository;
import pl.gameshop.domain.repository.PublisherRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/games") @RequiredArgsConstructor
public class GameController
{
    private static final Logger log = LoggerFactory.getLogger(GameController.class);
    private final GameRepository gameRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;

    @ModelAttribute("categoriesList")
    public List<Category> categories() { return categoryRepository.getAllByCategoryGroupLike("GAME"); }

    @ModelAttribute(name = "publishersList")
    public List<Publisher> publishers() { return publisherRepository.findAll(); }

    @GetMapping({"/", "/all"})
    public String getAllGames(Model model)
    {
        model.addAttribute("gamesList", gameRepository.findAll());
        return "/games/all";
    }

    @GetMapping("/add")
    public String prepareAddGame(Model model)
    {
        model.addAttribute("game", new Game());
        return "/games/add";
    }

    @PostMapping("/add")
    public String processAddGame(@Valid Game game,
                                BindingResult bindingResult)
    {
        log.info("Gra do dodania :: {}", game);
        if(bindingResult.hasErrors())
        {
            log.warn("Błąd zapisu obiektu {}", game.toString());
        }
        gameRepository.save(game);
        log.info("Zapisano obiekt :: {}", game);
        return "redirect:/games/all";
    }
}
