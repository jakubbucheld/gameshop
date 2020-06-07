package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gameshop.domain.model.Category;
import pl.gameshop.domain.repository.CategoryRepository;
import pl.gameshop.enums.Categories;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@Transactional
@RequestMapping("/categories") @RequiredArgsConstructor
public class CategoryController
{
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final CategoryRepository categoryRepository;

    @ModelAttribute(name = "categoriesEnum")
    public List<String> categoriesEnum()
    {
        List<String> list = new ArrayList<>();
        EnumSet.allOf(Categories.class).stream()
                .forEach(a -> list.add(a.name()));

        return list;
    }

    @GetMapping({"/all", "/"})
    public String allCategories(Model model)
    {
        model.addAttribute("categoriesList", categoryRepository.findAll());
        return "/categories/all";
    }

    @GetMapping("/add")
    public String prepareAddCategory(Model model)
    {
        model.addAttribute("category", new Category());
        return "/categories/add";
    }

    @PostMapping("/add")
    public String processAddCategory(@Valid Category category,
                                     BindingResult bindingResult)
    {
        log.info("kategoria do zapisu :: {}", category);
        if (bindingResult.hasErrors())
        {
            log.warn("Błąd zapisu obiektu");
            return "/categories/add";
        }
        log.info("Zapisano obiekt :: {}", category);
        categoryRepository.save(category);
        return "redirect:/categories/all";
    }
}
