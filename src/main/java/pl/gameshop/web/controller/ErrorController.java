package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller @RequiredArgsConstructor
public class ErrorController
{
    @GetMapping("/403")
    public String forbidden(Model model)
    {
        return "/403";
    }
}
