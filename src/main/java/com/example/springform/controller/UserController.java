package com.example.springform.controller;

import com.example.springform.model.User;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    // Create a Logger instance
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        logger.info("Registration form loaded.");
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult,
                               Model model) {
        logger.info("Received registration request for user: {}", user.getName());

        // Check for any validation errors
        if (bindingResult.hasErrors()) {
            logger.warn("Validation errors found: {}", bindingResult.getAllErrors());
            return "register";
        }

        // Log user registration success
        logger.info("New user registered: Name: {}, Email: {}", user.getName(), user.getEmail());
        return "success";
    }
}
