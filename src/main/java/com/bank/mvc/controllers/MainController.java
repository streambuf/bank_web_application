package com.bank.mvc.controllers;

import com.bank.mvc.models.User;
import com.bank.mvc.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    @ModelAttribute("clients")
    public Collection<User> getClients2() {
        return null;
    }

    @RequestMapping(value = "/clientList", method = {RequestMethod.GET, RequestMethod.HEAD})
    @ModelAttribute("clients")
    public Collection<User> getClients() {
        return userService.getAllClients();
    }

    @RequestMapping("/clientDetails")
    public User getClient(@RequestParam(value="id", required=true) int clientId) {
        return userService.getClientById(clientId);
    }

}
