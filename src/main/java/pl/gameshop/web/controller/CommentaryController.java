package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gameshop.domain.model.Article;
import pl.gameshop.domain.model.ArticleCommentary;
import pl.gameshop.domain.model.User;
import pl.gameshop.domain.repository.ArticleCommentaryRepository;
import pl.gameshop.domain.repository.ArticleRepository;
import pl.gameshop.domain.repository.ProductCommentaryRepository;
import pl.gameshop.domain.repository.UserRepository;

import javax.validation.Valid;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/commentaries") @RequiredArgsConstructor
public class CommentaryController
{
    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

    private final ProductCommentaryRepository productCommentaryRepository;
    private final ArticleCommentaryRepository articleCommentaryRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    @ModelAttribute("usersList")
    public List<User> usersList() { return userRepository.findAll(); }

    @PostMapping("/addArticleCommentary")
    public String postArticleCommentary(@Valid ArticleCommentary commentary,
                                        BindingResult bindingResult)
    {
//        commentary.setArticle(articleRepository.getById(article));
//        Long id = articleRepository.getById(article).getId();
        log.info("Komentarz do dodania :: {}", commentary);
        if(bindingResult.hasErrors())
        {
            log.warn("Błąd podczas zapisu obiektu ArticleCommentary :: {}", commentary);
            return "redirect:/articles/read/{articleId}";
        }
        articleCommentaryRepository.save(commentary);
        log.info("Zapisano obiekt ArticleCommentary :: {}", commentary);
        return "redirect:/articles/read/"+commentary.getArticle().getId().toString();
    }
}
