package com.bank.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(ModelMap model) {
        model.addAttribute("message", "Test");
        return "hello";
    }
}
