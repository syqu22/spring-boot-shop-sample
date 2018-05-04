package com.syqu.shop.controller;

import com.syqu.shop.user.User;
import com.syqu.shop.user.UserService;
import com.syqu.shop.user.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private final UserService userService;
    private final UserValidator userValidator;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Autowired
    public RegisterController(UserService userService, @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, UserValidator userValidator, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, HttpServletRequest request) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            return "register";
        }

        userService.save(userForm);
        authenticateUserAndSetSession(userForm.getUsername(), userForm.getPassword(), request);

        return "redirect:/home";
    }

    private void authenticateUserAndSetSession(String username, String password, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        logger.debug(String.format("Auto login %s successfully!", username));
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
