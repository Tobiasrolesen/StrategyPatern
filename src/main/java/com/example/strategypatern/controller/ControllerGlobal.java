package com.example.strategypatern.controller;

import com.example.strategypatern.model.User;
import com.example.strategypatern.service.validation.SimpleValidationStrategy;
import com.example.strategypatern.service.validation.StrictValidationStrategy;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.strategypatern.service.LoginService;

@Controller
public class ControllerGlobal {

    LoginService loginService = new LoginService();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/submit")
    //Session sikre at vi ikke taber data ved redirect
    public String submit(@RequestParam String fname, @RequestParam String password, @RequestParam String email, Model model, HttpSession session) {
        loginService.validateUser(fname, password, email);

        User user = loginService.createUser(fname, password, email);
        session.setAttribute("user", user);

        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        //Session sikre at vi ikke taber data ved redirect
        Object user = session.getAttribute("user");
        model.addAttribute("user", user);
        return "profile";
    }

}
