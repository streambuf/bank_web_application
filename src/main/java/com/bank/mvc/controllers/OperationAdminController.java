package com.bank.mvc.controllers;

import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.models.Account;
import com.bank.mvc.utils.JsonRequest;
import com.bank.mvc.utils.JsonResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Zalman on 26.05.2015.
 */

@Controller
@RequestMapping("/dashboard/admin/*")
public class OperationAdminController {

    final static Logger logger = Logger.getLogger(OperationEmployeeController.class);
    private static String path = "/dashboard/admin/";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/add-role-employee/{userId}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse addUserRoleEmployee(@PathVariable("userId") long userId) {
        logger.info("POST: " + path + "/user/add-role-employee/" + userId);
        Map<String, String> data = new HashMap<>();
        userService.addRoleEmployee(userId);
        data.put("add", "OK");
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/user/delete/{userId}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse deleteUser(@PathVariable("userId") long userId) {
        logger.info("POST: " + path + "/user/delete/" + userId);
        Map<String, String> data = new HashMap<>();
        userService.deleteUser(userService.getUserById(userId));
        data.put("delete", "OK");
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/get-memory", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse getMemory() {
        Map<String, String> data = new HashMap<>();
        Double mem = ((double) Runtime.getRuntime().freeMemory() / Runtime.getRuntime().totalMemory()) * 100 ;
        data.put("memory", String.valueOf(mem.intValue()));
        return new JsonResponse("OK", data);
    }





}
