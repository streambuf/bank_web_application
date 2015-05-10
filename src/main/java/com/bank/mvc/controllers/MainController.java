package com.bank.mvc.controllers;


import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.validation.UserValidator;
import com.bank.mvc.models.User;
import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.utils.JsonResponse;
import com.bank.mvc.utils.PasswordEncoder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class MainController {

    final static Logger logger = Logger.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    MessageSource msgSrc;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/dashboard/client/main", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboard(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);

        return "dashboard_client_main";
    }

    @RequestMapping(value = "/access_denied", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String accessDenied() {
        return "access_denied";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse createNewUser(@RequestBody User user) {
        logger.info("POST: /register");
        Map<String, String> data = new HashMap<String, String>();
        userValidator.validate(user, data);
        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }
        // encode password sha256
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.saveUser(user);
        data.put("message", msgSrc.getMessage("registerform.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }


}
