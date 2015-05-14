package com.bank.mvc.controllers;

import com.bank.mvc.domain.service.*;
import com.bank.mvc.domain.validation.OperationCurrencyExchangeValidator;
import com.bank.mvc.domain.validation.OperationTransferValidator;
import com.bank.mvc.domain.validation.UserValidator;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.OperationCurrencyExchange;
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
@RequestMapping("/dashboard/client/*")
public class OperationController {

    final static Logger logger = Logger.getLogger(OperationController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private OperationTransferService operationTransferService;

    @Autowired
    private OperationCurrencyExchangeService operationCurrencyExchangeService;

    @Autowired
    private OperationCurrencyExchangeValidator operationCurrencyExchangeValidator;

    @Autowired
    private OperationTransferValidator operationTransferValidator;

    @Autowired
    private OperationServicesPaymentService operationServicesPaymentService;

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

        operationTransferService.saveOperationTransfer(operationTransfer);
        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/dashboard/client/currency-exchange/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationCurrencyExchange(@RequestBody OperationCurrencyExchange operationCurrencyExchange) {
        logger.info("POST: /dashboard/client/currency-exchange/send");

        Map<String, String> data = operationCurrencyExchangeValidator.validate(operationCurrencyExchange);

        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }

        operationCurrencyExchangeService.saveOperationCurrencyExchange(operationCurrencyExchange);

        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }
}
