package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gameshop.domain.model.Product;
import pl.gameshop.domain.model.shopping.Order;
import pl.gameshop.domain.model.shopping.OrderRecord;
import pl.gameshop.domain.repository.OrderRecordRepository;
import pl.gameshop.domain.repository.OrderRepository;
import pl.gameshop.service.CartService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller @Scope("session")
@RequestMapping("/cart") @RequiredArgsConstructor
public class CartController
{
    private final OrderRepository orderRepository;
    private final OrderRecordRepository orderRecordRepository;
    private final CartService cartService;


    @GetMapping
    public String showCart(Model model)
    {
        return "/cart";
    }

    @PostMapping("/addToCart")
    public String addProductToCart(@Valid Long productId,
                                  @AuthenticationPrincipal Principal principal,
                                  HttpSession session)
    {
        if(session.getAttribute("cart")==null)
        {
           cartService.createSessionCart(session);
        }
        Order cart =(Order) session.getAttribute("cart");
        cart.
    }
}
