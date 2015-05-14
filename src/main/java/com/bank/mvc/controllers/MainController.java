package com.bank.mvc.controllers;


import com.bank.mvc.dao.ExchangeRateDao;
import com.bank.mvc.domain.service.CategoryServicesService;
import com.bank.mvc.domain.validation.UserValidator;
import com.bank.mvc.models.ExchangeRate;
import com.bank.mvc.models.User;
import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.utils.JsonResponse;
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
    private CategoryServicesService categoryServicesService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    MessageSource msgSrc;


    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/dashboard/client/main", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardClientMain(Model model) {
        User user = getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("categoryServices", categoryServicesService.getAllCategoryServices());
        return "dashboard_client_main";
    }

    @RequestMapping(value = "/dashboard/client/transfer", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardClientTransfer(Model model) {
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return "dashboard_client_transfer";
    }

    @RequestMapping(value = "/dashboard/client/currency-exchange", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardClientCurrencyExchange(Model model) {
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return "dashboard_client_currency_exchange";
    }

    @RequestMapping("/dashboard/client/service/{serviceId}")
    public String dashboardClientService(@PathVariable("serviceId") int serviceId) {

        return "1234";
    }

    @RequestMapping(value = "/access_denied", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String accessDenied() {
        return "access_denied";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse createNewUser(@RequestBody User user) {
        logger.info("POST: /register");
        Map<String, String> data = userValidator.validate(user);
        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }

        userService.saveUser(user);
        data.put("message", msgSrc.getMessage("registerform.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

    private User getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // deprecated (update user)
        return userService.getUserById(user.getId());
    }





}
