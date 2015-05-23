package com.bank.mvc.controllers;

import com.bank.mvc.domain.service.*;
import com.bank.mvc.domain.validation.*;
import com.bank.mvc.models.*;
import com.bank.mvc.utils.JsonResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private static String path = "/dashboard/client/";

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
    private OperationServicesPaymentValidator operationServicesPaymentValidator;

    @Autowired
    private OperationServicesPaymentService operationServicesPaymentService;

    @Autowired
    private CreditValidator creditValidator;

    @Autowired
    private CreditService creditService;

    @Autowired
    private  CreditRepaymentService creditRepaymentService;

    @Autowired
    private CreditRepaymentValidator creditRepaymentValidator;

    @Autowired
    private ContributionRateService contributionRateService;

    @Autowired
    private ContributionService contributionService;

    @Autowired
    private ContributionValidator contributionValidator;

    @Autowired
    MessageSource msgSrc;


    @RequestMapping(value = "/transfer/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public @ResponseBody
    JsonResponse createNewOperationTransfer(@RequestBody OperationTransfer operationTransfer) {
        logger.info("POST: " + path + "transfer/send");

        Map<String, String> data = operationTransferValidator.validate(operationTransfer);

        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }

        operationTransferService.saveOperationTransfer(operationTransfer);
        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/currency-exchange/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationCurrencyExchange(@RequestBody OperationCurrencyExchange operationCurrencyExchange) {
        logger.info("POST: " + path + "currency-exchange/send");

        Map<String, String> data = operationCurrencyExchangeValidator.validate(operationCurrencyExchange);

        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }

        operationCurrencyExchangeService.saveOperationCurrencyExchange(operationCurrencyExchange);

        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/payment-services/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationServicesPayment(@RequestBody OperationServicesPayment operationServicesPayment) {
        logger.info("POST: " + path + "payment-services/send");

        Map<String, String> data = operationServicesPaymentValidator.validate(operationServicesPayment);

        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }

        operationServicesPaymentService.saveOperationServicesPayment(operationServicesPayment);

        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/credit/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationCredit(@RequestBody Credit credit) {
        logger.info("POST: " + path + "credit/send");

        Map<String, String> data = creditValidator.validate(credit);

        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }

        creditService.saveCredit(credit);

        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/credit-repayment/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationCreditRepayment(@RequestBody CreditRepayment creditRepayment) {
        logger.info("POST: " + path + "credit/send");

        Map<String, String> data = creditRepaymentValidator.validate(creditRepayment);

        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }

        creditRepaymentService.saveCreditRepayment(creditRepayment);

        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/contribution-rate/get", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationContributionRate(@RequestBody Contribution contribution) {
        logger.info("POST: " + path + "credit/send");
        Map<String, String> data = new HashMap<>();
        ContributionRate contributionRate = contributionRateService.getRepaymentByContribution(contribution);
        if (contributionRate != null) {
            data.put("rate", String.valueOf(contributionRate.getRate()) + "%");
        } else {
            data.put("rate", "0%");
        }
        return new JsonResponse("OK", data);
    }

    @RequestMapping(value = "/contribution/send", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse createNewOperationContribution(@RequestBody Contribution contribution) {
        logger.info("POST: " + path + "contribution/send");

        Map<String, String> data = contributionValidator.validate(contribution);

        if (!data.isEmpty()) {
            return new JsonResponse("ERROR", data);
        }

        contributionService.saveContribution(contribution);

        data.put("message", msgSrc.getMessage("operationForm.successMessage", null, Locale.getDefault()));
        return new JsonResponse("OK", data);
    }

}
