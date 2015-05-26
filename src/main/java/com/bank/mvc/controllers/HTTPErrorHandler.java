package com.bank.mvc.controllers;

import com.bank.mvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zalman on 14.05.2015.
 */

@Controller
public class HTTPErrorHandler extends AbstractController {

    @RequestMapping(value="/error/404")
    public String error404(Model model) {
        User user = getCurrentUser();
        if (user == null) return "redirect:/";
        model.addAttribute("user", user);
        return "404";
    }
}
