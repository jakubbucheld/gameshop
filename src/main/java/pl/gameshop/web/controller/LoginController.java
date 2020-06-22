package pl.gameshop.web.controller;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login") @RequiredArgsConstructor
public class LoginController
{

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public String prepareLoginPage(@RequestHeader(value = "Referer", required = false) String referer,
                                   Model model)
    {
        model.addAttribute("referer", referer);
        log.info("referer :: {}", referer);
        return "/login-form";
    }
}
