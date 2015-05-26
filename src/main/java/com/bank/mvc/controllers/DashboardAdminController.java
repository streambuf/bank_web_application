package com.bank.mvc.controllers;

import com.bank.mvc.models.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Zalman on 25.05.2015.
 */

@Controller
@RequestMapping("/dashboard/admin/*")
class DashboardAdminController extends AbstractController {

    private final static Logger logger = Logger.getLogger(DashboardAdminController.class);

    private static String path = "/dashboard/admin/";

    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardAdminMain(Model model) {
        logger.info("GET: " + path + "main");
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);
        return "dashboard_admin_main";
    }

    @RequestMapping(value = "/users", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String dashboardAdminUsers(Model model) {
        logger.info("GET: " + path + "users");
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);
        List<User> users = (List<User>)userService.getAllUsers();
        model.addAttribute("users", users);
        return "dashboard_admin_users";
    }



}
