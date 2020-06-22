package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import pl.gameshop.domain.model.Product;
import pl.gameshop.domain.model.ShippingData;
import pl.gameshop.domain.model.User;
import pl.gameshop.domain.model.shopping.Order;
import pl.gameshop.domain.model.shopping.OrderRecord;
import pl.gameshop.domain.model.shopping.ShoppingCart;
import pl.gameshop.domain.repository.OrderRecordRepository;
import pl.gameshop.domain.repository.OrderRepository;
import pl.gameshop.domain.repository.ProductRepository;
import pl.gameshop.domain.repository.UserRepository;
import pl.gameshop.service.CartService;
import pl.gameshop.service.OrderService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller  @RequiredArgsConstructor
@RequestMapping("/cart")
@Scope("session")
@SessionAttributes("shoppingCart")
@Transactional
public class CartController
{
    private final OrderRepository orderRepository;
    private final OrderRecordRepository orderRecordRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartService cartService;

    @Autowired
    private ShoppingCart shoppingCart;

    private final HttpSession session;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);


    @PostMapping("/addRecord")
    public String postOrderRecord(@Valid OrderRecord orderRecord,
                                 BindingResult bindingResult,
                                  @RequestHeader(value = "Referer", required = false) String referer)
    {
        if (session.getAttribute("shoppingCart")==null)
        {
            session.setAttribute("shoppingCart", new ShoppingCart());
        }

        log.info("OrderRecord do zapisu :: {}", orderRecord);

        if (orderRecord.getQuantity()==null)
        {
            return "redirect:/products/all";
        }

        if (bindingResult.hasErrors())
        {
            log.warn("Błąd dodania rekordu do koszyka :: {}", orderRecord);
        }
        log.info("Do koszyka dodano :: {}", orderRecord);
        cartService.addProductToCart(orderRecord, shoppingCart);

        log.info(referer);
        if(referer.equals("http://localhost:8080/cart/finalize"))
        {
            return "redirect:/cart/finalize";
        }
        else
        {
            return "redirect:/products/all";
        }
    }

    @PostMapping("/remove")
    public String removeOrderRecord(@Valid OrderRecord record,
                                    BindingResult bindingResult)
    {
        log.info("Z koszyka usunięto :: {}", record);
        cartService.removeProductFromCart(record,(ShoppingCart) session.getAttribute("shoppingCart"));
        return "";
    }
    @GetMapping("/finalize")
    public String prepareFinalizeOrder(Model model,
                                       @AuthenticationPrincipal Principal principal)
    {
        model.addAttribute("orderRecord", new OrderRecord());
        model.addAttribute(session.getAttribute("shoppingCart"));

        return "/cart/finalize";
    }

    @PostMapping("/finalize")
    public String processFinalizeOrder(@AuthenticationPrincipal Principal principal)
    {
        log.info("principal :: {}", principal);
        if(principal==null)
        {
            return "redirect:/login";
        }

        log.info("principal :: {}", principal.getName());
        User user = userRepository.getByUsername(principal.getName());

        log.info("koszyk :: {}", shoppingCart.toString());
        shoppingCart.finalizeOrder(user);
        shoppingCart.clearCart();

        return "redirect:/products/all";
    }

}
