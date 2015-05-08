package com.bank.mvc.controllers;


import com.bank.mvc.models.User;
import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messages;

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
        System.out.println("User data: \n" + user.toString());

        return new JsonResponse("ERROR", "errors");
    }

    public MessageSource getMessages() {
        return messages;
    }
    public void setMessages(MessageSource messages) {
        this.messages = messages;
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
