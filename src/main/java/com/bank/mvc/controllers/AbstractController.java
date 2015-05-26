package com.bank.mvc.controllers;

import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.models.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Zalman on 25.05.2015.
 */


class AbstractController {

    final static private Logger logger = Logger.getLogger(AbstractController.class);

    @Autowired
    protected UserService userService;

    User getCurrentUser() {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userService.getUserById(user.getId());
        } catch (ClassCastException ex) {
            logger.info("GET: " + ex.getMessage());
            return null;
        }
    }
}
