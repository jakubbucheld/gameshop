package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gameshop.domain.model.Article;
import pl.gameshop.domain.model.ArticleCommentary;
import pl.gameshop.domain.model.Category;
import pl.gameshop.domain.model.User;
import pl.gameshop.domain.repository.ArticleCommentaryRepository;
import pl.gameshop.domain.repository.ArticleRepository;
import pl.gameshop.domain.repository.CategoryRepository;
import pl.gameshop.domain.repository.UserRepository;

import javax.persistence.PrePersist;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/articles") @RequiredArgsConstructor
public class ArticleController {
    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ArticleCommentaryRepository articleCommentaryRepository;

    /**
     * MODEL ATTRIBUTES
     */

    @ModelAttribute(name = "usersList")
    public List<User> listOfUsers() {
        return userRepository.findAll();
    }

    @ModelAttribute("categoriesList")
    public List<Category> categories() {
        return categoryRepository.getAllByCategoryGroupLike("ARTICLE");
    }

    /** GETS AND POSTS */
    /**
     * LIST
     */
    @GetMapping({"/all", "/"})
    public String getAll(Model model,
                         @RequestParam(required = false) String search)
    {
        if (search==null)
        {
            model.addAttribute("articlesList", articleRepository.findAll());
        } else {
            log.warn("Szukana fraza :: {}", search);
            model.addAttribute("articlesList",
                    articleRepository.getAllByTitleContainsOrAuthor_UsernameContains(search, search));
        }
        return "/articles/all";
    }

    /**
     * ADDING
     */

    @GetMapping("/add")
    public String prepareAddArticle(Model model)
    {
        model.addAttribute("article", new Article());
        return "/articles/add";
    }

    @PostMapping("/add")
    public String processAddArticle(@Valid Article article,
                                    BindingResult bindingResult,
                                    @AuthenticationPrincipal Principal principal)
    {
        User user = userRepository.getByUsername(principal.getName());

        article.setAuthor(user);
        log.info("Obiekt do zapisu :: {}", article);
        if (bindingResult.hasErrors()) {
            log.warn("Błąd zapisu obiektu :: {}", article);
        }
        articleRepository.save(article);
        log.info("Zapisany obiekt :: {}", article);
        return "redirect:/articles/all";
    }

    /**
     * DELETING
     */

    @PostMapping("/delete/{id}")
    public String processDeleteArticle(@PathVariable Long id) {
        Article article = articleRepository.getById(id);
        log.info("Artykuł do usunięcia :: {}", article);
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(article.getId());
            log.info("Usunięto artykuł :: {}", article);
        }
        return "redirect:/articles/all";
    }

    /**
     * VIEWING
     */

    @GetMapping("/read/{id}")
    public String readArticle(Model model,
                              @PathVariable Long id) {

        if (articleRepository.existsById(id)) {
            // nowy obiekt artykułu do formularza
            model.addAttribute("commentary", new ArticleCommentary());
            log.info("Wgrano pusty obiekt Commentary");

            // lista dotychczasowo dodanych komentarzy
            model.addAttribute("currentCommentaryList",
                    articleCommentaryRepository.getAllByArticle_IdOrderByTimeCreatedDesc(id));
            log.info("Wgrano listę komentarzy");

            model.addAttribute("article", articleRepository.getById(id));
            return "/articles/read";
        } else {
            return "redirect:/articles/all";
        }
    }
}