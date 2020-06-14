package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gameshop.domain.model.*;
import pl.gameshop.domain.repository.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products") @RequiredArgsConstructor
public class ProductController
{
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository productRepository;
    private final GameRepository gameRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;
    private final ProductCommentaryRepository productCommentaryRepository;
    private final UserRepository userRepository;

    /**  >>> MODEL ATTRIBUTES  */
    @ModelAttribute(name = "usersList")
    public List<User> listOfUsers() { return userRepository.findAll(); }

    @ModelAttribute("gamesList")
    public List<Game> games() { return gameRepository.findAll(); }

    @ModelAttribute("publishersList")
    public List<Publisher> publishers() { return publisherRepository.findAll(); }

    @ModelAttribute("categoriesList")
    public List<Category> categories() { return categoryRepository.getAllByCategoryGroupLike("PRODUCT"); }

    /** >>> ACTIONS */

    @GetMapping({"/", "all"})
    public String getProductList(Model model)
    {
        model.addAttribute("products", productRepository.findAll());
        return "/products/all";
    }

    @GetMapping("/add")
    public String prepareAddProduct(Model model)
    {
        model.addAttribute("product", new Product());
        return "/products/add";
    }

    @PostMapping("/add")
    public String processAddProduct(@Valid Product product,
                                    BindingResult bindingResult)
    {
        log.info("Produkt do dodania :: {}", product);
        if(bindingResult.hasErrors())
        {
            log.warn("Błąd zapisu obiektu :: {}", product);
        }
        productRepository.save(product);
        log.info("Zapisano obiekt :: {}", product);
        return "redirect:/products/all";
    }

    /** READ */

    @GetMapping("/view/{id}")
    public String viewProduct(Model model,
                              @PathVariable Long id)
    {
        // nowy obiekt artykułu do formularza
        model.addAttribute("commentary", new ProductCommentary());
        log.info("Wgrano pusty obiekt Commentary");

        // lista dotychczasowo dodanych komentarzy
        model.addAttribute("currentCommentaryList",
                productCommentaryRepository.getAllByProduct_IdOrderByTimeCreatedDesc(id));
        log.info("Wgrano listę komentarzy");

        if (productRepository.existsById(id))
        {
            model.addAttribute("product", productRepository.getById(id));
            return "/products/view";
        }
        else
        {
            return "redirect:/products/all";
        }
    }
}
