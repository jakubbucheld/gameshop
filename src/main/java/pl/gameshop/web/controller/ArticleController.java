package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gameshop.domain.model.Article;
import pl.gameshop.domain.model.Category;
import pl.gameshop.domain.model.User;
import pl.gameshop.domain.repository.ArticleRepository;
import pl.gameshop.domain.repository.CategoryRepository;
import pl.gameshop.domain.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/articles") @RequiredArgsConstructor
public class ArticleController
{
    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @ModelAttribute(name = "usersList")
    public List<User> listOfUsers() { return userRepository.findAll(); }

    @ModelAttribute("categoriesList")
    public List<Category> categories() { return categoryRepository.getAllByCategoryGroupLike("ARTICLE"); }

    @GetMapping({"/", "/all"})
    public String getAll(Model model)
    {
        model.addAttribute("articlesList", articleRepository.findAll());
        return "/articles/all";
    }

    @GetMapping("/add")
    public String prepareAddArticle(Model model)
    {
        model.addAttribute("article", new Article());
        return "/articles/add";
    }

    @PostMapping("/add")
    public String processAddArticle(@Valid Article article,
                                    BindingResult bindingResult)
    {
        log.info("Obiekt do zapisu :: {}", article);
        if(bindingResult.hasErrors())
        {
            log.warn("Błą zapisu obiektu :: {}", article);
        }
        articleRepository.save(article);
        log.info("Zapisany obiekt :: {}", article);
        return "redirect:/articles/all";
    }
}
