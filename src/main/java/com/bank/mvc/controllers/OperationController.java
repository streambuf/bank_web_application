package com.bank.mvc.controllers;

import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.OperationTransferService;
import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.domain.validation.OperationTransferValidator;
import com.bank.mvc.domain.validation.UserValidator;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.OperationTransfer;
import com.bank.mvc.utils.JsonResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Zalman on 11.05.2015.
 */

@Controller
public class OperationController {

    final static Logger logger = Logger.getLogger(OperationController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private OperationTransferService operationTransferService;

    @Autowired
    private OperationTransferValidator operationTransferValidator;

    @Autowired
    MessageSource msgSrc;

    @RequestMapping(value = "/dashboard/client/transfer/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationTransfer(@RequestBody OperationTransfer operationTransfer) {
        logger.info("POST: /dashboard/client/transfer/send");

        Map<String, String> data = operationTransferValidator.validate(operationTransfer);

        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }

        Account account = accountService.getAccountById(operationTransfer.getAccountSenderId());
        operationTransfer.setAccountSender(account);
        operationTransfer.setUser(account.getUser());
        operationTransfer.setOperationDate(new Date());
        operationTransferService.saveOperationTransfer(operationTransfer);

        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }
}
