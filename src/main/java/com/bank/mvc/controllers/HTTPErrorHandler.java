package com.bank.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zalman on 14.05.2015.
 */

@Controller
public class HTTPErrorHandler {

    @RequestMapping(value="/error/404")
    public String error404() {
        return "404";
    }
}
