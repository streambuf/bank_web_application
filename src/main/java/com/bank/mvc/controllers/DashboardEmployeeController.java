package com.bank.mvc.controllers;

import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.models.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Zalman on 23.05.2015.
 */

@Controller
@RequestMapping("/dashboard/employee/*")
public class DashboardEmployeeController {
    final static Logger logger = Logger.getLogger(DashboardEmployeeController.class);

    private static String path = "/dashboard/employee/";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardClientMain(Model model) {
        logger.info("GET: " + path + "main");
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);
        return "dashboard_employee_main";
    }

    @RequestMapping(value = "/clients", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardEmployeeClients(Model model) {
        logger.info("GET: " + path + "main");
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);
        List<User> users = (List<User>)userService.getAllUnconfirmedUsers();
        model.addAttribute("users", users);
        return "dashboard_employee_clients";
    }

    @RequestMapping(value = "client/{clientId}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardEmployeeClient(@PathVariable("clientId") long clientId, Model model) {
        logger.info("GET: " + path + "client/" + clientId);
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);

        User client = userService.getUserById(clientId);

        model.addAttribute("client", client);
        return client == null ? "404" : "dashboard_employee_client";
    }

    private User getCurrentUser() {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userService.getUserById(user.getId());
        } catch (ClassCastException ex) {
            logger.info("GET: " + ex.getMessage());
            return null;
        }
    }

}
