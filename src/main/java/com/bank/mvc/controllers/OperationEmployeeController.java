package com.bank.mvc.controllers;

import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.CreditService;
import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.models.*;
import com.bank.mvc.utils.JsonRequest;
import com.bank.mvc.utils.JsonResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.Locale;
import java.util.Map;

/**
 * Created by Zalman on 23.05.2015.
 */

@Controller
@RequestMapping("/dashboard/employee/*")
class OperationEmployeeController {
    private final static Logger logger = Logger.getLogger(OperationEmployeeController.class);
    private static String path = "/dashboard/employee/";

    @Autowired
    private UserService userService;

    @Autowired
    private CreditService creditService;

    @Autowired
    private AccountService accountService;

    @Autowired
    MessageSource msgSrc;


    @RequestMapping(value = "/clients/delete", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse deleteUser(@RequestBody JsonRequest request) {
        logger.info("POST: " + path + "clients/delete");

        User user = userService.getUserById(request.getLongParam());
        userService.deleteUser(user);

        Map<String, String> data = new HashMap<>();
        data.put("delete", "OK");
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/credit/delete", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse deleteCredit(@RequestBody JsonRequest request) {
        logger.info("POST: " + path + "clients/delete");

        Credit credit = creditService.getCreditById(request.getLongParam());
        creditService.deleteCredit(credit);

        Map<String, String> data = new HashMap<>();
        data.put("delete", "OK");
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/client/passport/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationPassport(@RequestBody Passport passport) {
        logger.info("POST: " + path + "/client/passport/send");
        userService.savePassport(passport);
        Map<String, String> data = new HashMap<>();
        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/credit/confirm/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationPassport(@RequestBody JsonRequest request) {
        logger.info("POST: " + path + "/credit/confirm/send");
        Credit credit = creditService.getCreditById(request.getLongParam());
        creditService.confirmCredit(credit);
        Map<String, String> data = new HashMap<>();
        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/account/create/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewAccount(@RequestBody Account account) {
        logger.info("POST: " + path + "/account/create/send");
        accountService.saveAccount(account);
        Map<String, String> data = new HashMap<>();
        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

}
