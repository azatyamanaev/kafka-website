package ru.kfu.kafkaWebSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kfu.kafkaWebSite.dto.UserSignUpDto;
import ru.kfu.kafkaWebSite.model.User;
import ru.kfu.kafkaWebSite.service.UserService;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-in")
    public String signIn(@RequestParam(required = false) String error, Model model) {
        Optional.ofNullable(error).ifPresent(e -> model.addAttribute("error", error));
        return "sign-in";
    }

    @GetMapping("/sign-up")
    public String signUpForm(@RequestParam(required = false) String error, Model model) {
        Optional.ofNullable(error).ifPresent(e -> model.addAttribute("error", error));
        model.addAttribute("userDto", new UserSignUpDto());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(UserSignUpDto userDto) {
        System.out.println(userDto);
        try {
            userService.signUpUser(userDto, User.Role.CONTRIBUTOR);
        } catch (EntityExistsException e) {
            return "redirect:/sign-up?error=1";
        } catch (IllegalArgumentException e) {
            return "redirect:/sign-up?error=2";
        }
        return "redirect:/";
    }
}
