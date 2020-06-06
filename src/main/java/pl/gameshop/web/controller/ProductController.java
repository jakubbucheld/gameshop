package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gameshop.domain.model.Game;
import pl.gameshop.domain.model.Product;
import pl.gameshop.domain.model.Publisher;
import pl.gameshop.domain.repository.GameRepository;
import pl.gameshop.domain.repository.ProductRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products") @RequiredArgsConstructor
public class ProductController
{
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository productRepository;
    private final GameRepository gameRepository;

    @ModelAttribute("gamesList")
    public List<Game> games() { return gameRepository.findAll(); }

    @ModelAttribute("publishersList")
    public List<Publisher> publishers() { return }
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
        return "products/add";
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
}
