package com.bank.mvc.controllers;


import com.bank.mvc.domain.validation.UserValidator;
import com.bank.mvc.models.User;
import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.utils.JsonResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class MainController {

    final static Logger logger = Logger.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping(value = "/access_denied", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String accessDenied() {
        return "access_denied";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse createNewUser(@RequestBody User user)  {
        logger.info("POST: /register");
        Map<String, String> errors = new HashMap<String, String>();
        userValidator.validate(user, errors);
        return new JsonResponse("OK", errors);
    }


//    @RequestMapping(value = "/clientList", method = {RequestMethod.GET, RequestMethod.HEAD})
//    @ModelAttribute("clients")
//    public Collection<User> getClients() {
//        return userService.getAllClients();
//    }
//
//    @RequestMapping("/clientDetails")
//    public User getClient(@RequestParam(value="id", required=true) int clientId) {
//        return userService.getClientById(clientId);
//    }


}
