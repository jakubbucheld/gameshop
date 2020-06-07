package pl.gameshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gameshop.domain.model.User;
import pl.gameshop.domain.repository.UserRepository;
import pl.gameshop.security.Roles;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
@RequestMapping("/users") @RequiredArgsConstructor
public class UserController
{
    private final UserRepository userRepository;

    @ModelAttribute("rolesList")
    public List<String> roles()
    {
        List<String> listOfRoles = new ArrayList<>();
        EnumSet.allOf(Roles.class).stream()
                .forEach(r -> listOfRoles.add(r.name()));
        return listOfRoles;
    }

    @GetMapping({"/", "/all"})
    public String getAll(Model model)
    {
        model.addAttribute("usersList", userRepository.findAll());
        return "/users/all";
    }

    @PostMapping("/{id}/addroles")
    public String addUserRoles(@PathVariable Long id,
                                @RequestParam String roleName)
    {
        User user = userRepository.getById(id);
        user.getRoles().add(Roles.valueOf(roleName).name());
        return "redirect:/users/all";
    }

    @PostMapping("/{id}/deleteroles")
    public String deleteUserRoles(@PathVariable Long id,
                                  @RequestParam String roleName)
    {
        User user = userRepository.getById(id);
        user.getRoles().remove(Roles.valueOf(roleName).name());
        userRepository.save(user);
        return "redirect:/users/all";
    }
}
