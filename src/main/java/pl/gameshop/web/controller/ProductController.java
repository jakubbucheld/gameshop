package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gameshop.domain.repository.ProductRepository;

@Controller
@RequestMapping("/products") @RequiredArgsConstructor
public class ProductController
{
    private final ProductRepository productRepository;

    @GetMapping({"/", "all"})
    public String getProductList(Model model)
    {
        model.addAttribute("products", productRepository.findAll());
        return "/products/all";
    }
}
