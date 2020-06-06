package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gameshop.utils.SecurityUtils;

@Controller
@RequestMapping("/") @RequiredArgsConstructor //ReqArgsConstr automatycznie dodaje konstruktor z potrzebnych obiektów (dao, seriwsy, etc)
public class HomeController
{
    @GetMapping({"/", "/home"})
    public String home(Model model)
    {
        model.addAttribute("username", SecurityUtils.getUsername());
        return "/home";
    }
}
