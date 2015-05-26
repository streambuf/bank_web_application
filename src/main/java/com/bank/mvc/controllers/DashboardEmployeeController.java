package com.bank.mvc.controllers;

import com.bank.mvc.domain.service.CreditService;
import com.bank.mvc.models.Credit;
import com.bank.mvc.models.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
class DashboardEmployeeController extends AbstractController {
    private final static Logger logger = Logger.getLogger(DashboardEmployeeController.class);

    private static String path = "/dashboard/employee/";

    @Autowired
    private CreditService creditService;

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
        logger.info("GET: " + path + "clients");
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);
        List<User> users = (List<User>)userService.getAllUnconfirmedUsers();
        model.addAttribute("users", users);
        return "dashboard_employee_clients";
    }

    @RequestMapping(value = "/clients-account", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardEmployeeClientsAccount(Model model) {
        logger.info("GET: " + path + "clients-account");
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);
        List<User> users = (List<User>)userService.getAllConfirmedUsers();
        model.addAttribute("users", users);
        return "dashboard_employee_clients_account";
    }

    @RequestMapping(value = "/credits", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardEmployeeCredits(Model model) {
        logger.info("GET: " + path + "credits");
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);
        List<Credit> credits = (List<Credit>)creditService.getAllUnconfirmedCredits();
        model.addAttribute("credits", credits);
        return "dashboard_employee_credits";
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

    @RequestMapping(value = "credit/{creditId}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardEmployeeCredit(@PathVariable("creditId") long creditId, Model model) {
        logger.info("GET: " + path + "credit/" + creditId);
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);

        Credit credit = creditService.getCreditById(creditId);

        model.addAttribute("credit", credit);
        return credit == null ? "404" : "dashboard_employee_credit";
    }

    @RequestMapping(value = "account/{clientId}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardEmployeeAccount(@PathVariable("clientId") long clientId, Model model) {
        logger.info("GET: " + path + "client/" + clientId);
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);

        User client = userService.getUserById(clientId);

        model.addAttribute("client", client);
        return client == null ? "404" : "dashboard_employee_account";
    }

}
