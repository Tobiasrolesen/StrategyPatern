package com.example.strategypatern.controller;

import com.example.strategypatern.model.User;
import com.example.strategypatern.service.RegistrationService;
import com.example.strategypatern.service.validation.ValidationMode;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerGlobal {

    private final RegistrationService registrationService;

    public ControllerGlobal(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register(@RequestParam(name = "mode", required = false, defaultValue = "SIMPLE") ValidationMode mode, Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("mode", mode);

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, @RequestParam(name = "mode", required = false, defaultValue = "SIMPLE") ValidationMode mode, HttpSession session, Model model) {

        registrationService.validateUser(user, mode);
        registrationService.saveUser(user);

        session.setAttribute("user", user);
        model.addAttribute("username", user.getUsername());

        return "profile";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        //Session sikre at vi ikke taber data ved redirect
        model.addAttribute("user", session.getAttribute("user"));
        return "profile";
    }

    @GetMapping("/users")
    public String list(Model model){
        model.addAttribute("users", registrationService.getAllUsers());
        return "users";
    }
}
