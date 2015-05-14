package com.bank.mvc.domain.validation;

import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.OrganizationService;
import com.bank.mvc.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zalman on 15.05.2015.
 */

@Component
public class OperationServicesPaymentValidator {

    @Autowired
    AccountService accountService;

    @Autowired
    OrganizationService organizationService;

    static String fieldClientIdentifier = "clientIdentifier";
    static String fieldQuantityOfMoney = "quantityOfMoney";
    static String fieldAccountSender = "accountSenderError";
    static double minQuantityOfMoney = 1;
    static double maxQuantityOfMoney = 100000;

    public Map<String, String> validate(OperationServicesPayment operationServicesPayment) {

        Map<String, String> errors = new HashMap<>();

        long accountSenderId =operationServicesPayment.getAccountSenderId();
        Account accountSender = accountService.getAccountById(accountSenderId);
        if (accountSender == null) {
            errors.put(fieldAccountSender, "Не выбран счет");
            return errors;
        } else if (accountSender.getCurrency() != ListCurrency.RUBLE) {
            errors.put(fieldAccountSender, "Необходимо выбрать счет в национальной валюте (рубль)");
        }

        long organizationId = operationServicesPayment.getOrganizationId();
        Organization organization = organizationService.getOrganizationById(organizationId);
        if (organization == null) {
            errors.put(fieldAccountSender, "Данной организации не существует");
            return errors;
        }

        String clientIdentifier = operationServicesPayment.getClientIdentifier();
        if (clientIdentifier == null || clientIdentifier.trim() == "") {
            errors.put(fieldClientIdentifier, "Поле не должно быть пустым");
        }


        double quantityOfMoney = operationServicesPayment.getQuantityOfMoney();
        if (quantityOfMoney < minQuantityOfMoney) {
            errors.put(fieldQuantityOfMoney, "Минимальная сумма составляет: " + minQuantityOfMoney);
        } else if (quantityOfMoney > maxQuantityOfMoney) {
            errors.put(fieldQuantityOfMoney, "Максимальная сумма составляет: " + maxQuantityOfMoney);
        } else if (accountSender.getBalance() < quantityOfMoney) {
            errors.put(fieldQuantityOfMoney, "На вашем счету недостаточно средств: " + accountSender.getBalance());
        }

        return errors;

    }
}
