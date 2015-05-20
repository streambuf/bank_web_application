package com.bank.mvc.domain.validation;

import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.CreditService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.Credit;
import com.bank.mvc.models.ListCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zalman on 20.05.2015.
 */

@Component
public class CreditValidator {

    static String fieldAccount = "accountError";
    static String fieldQuantityOfMoney = "quantityOfMoney";
    static String fieldPeriod = "period";
    static String fieldSalary = "salary";
    static String fieldPlaceOfWork = "placeOfWork";
    static double minQuantityOfMoney = 1;
    static double maxQuantityOfMoney = 100000;


    @Autowired
    CreditService creditService;

    @Autowired
    AccountService accountService;

    public Map<String, String> validate(Credit credit) {

        Map<String, String> errors = new HashMap<>();

        long accountSenderId = credit.getAccountId();
        Account accountSender = accountService.getAccountById(accountSenderId);
        if (accountSender == null) {
            errors.put(fieldAccount, "Не выбран счет");
            return errors;
        } else if (accountSender.getCurrency() != ListCurrency.RUBLE) {
            errors.put(fieldAccount, "Необходимо выбрать счет в национальной валюте (рубль)");
        }

        int period = credit.getPeriod();
        if (period < 1 || period > 36) {
            errors.put(fieldPeriod, "Срок может быть от 1 до 36 месяцев");
        }

        double salary = credit.getSalary();
        if (salary < 1) {
            errors.put(fieldSalary, "Введите вашу реальную заработную плату");
        }

        String clientIdentifier = credit.getPlaceOfWork();
        if (clientIdentifier == null || clientIdentifier.trim() == "") {
            errors.put(fieldPlaceOfWork, "Поле не должно быть пустым");
        }

        double quantityOfMoney = credit.getQuantityOfMoney();
        if (quantityOfMoney < minQuantityOfMoney) {
            errors.put(fieldQuantityOfMoney, "Минимальная сумма составляет: " + minQuantityOfMoney);
        } else if (quantityOfMoney > maxQuantityOfMoney) {
            errors.put(fieldQuantityOfMoney, "Максимальная сумма составляет: " + maxQuantityOfMoney);
        }
        return errors;
    }


}


