package com.bank.mvc.domain.validation;

import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.CreditRepaymentService;
import com.bank.mvc.domain.service.CreditService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.Credit;
import com.bank.mvc.models.CreditRepayment;
import com.bank.mvc.models.enums.ListCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zalman on 21.05.2015.
 */

@Component
public class CreditRepaymentValidator {

    private static String fieldAccount = "accountError";
    private static String fieldCredit = "creditError";
    private static String fieldQuantityOfMoney = "quantityOfMoney";
    static String fieldPeriod = "period";
    static String fieldSalary = "salary";
    static String fieldPlaceOfWork = "placeOfWork";
    static double minQuantityOfMoney = 1;
    static double maxQuantityOfMoney = 100000;

    @Autowired
    CreditRepaymentService creditRepaymentService;

    @Autowired
    CreditService creditService;

    @Autowired
    AccountService accountService;

    public Map<String, String> validate(CreditRepayment creditRepayment) {

        Map<String, String> errors = new HashMap<>();

        long accountSenderId = creditRepayment.getAccountId();
        Account accountSender = accountService.getAccountById(accountSenderId);
        if (accountSender == null) {
            errors.put(fieldAccount, "Не выбран счет");
            return errors;
        } else if (accountSender.getCurrency() != ListCurrency.RUBLE) {
            errors.put(fieldAccount, "Необходимо выбрать счет в национальной валюте (рубль)");
        }

        Credit credit = creditService.getCreditById(creditRepayment.getCreditId());
        if (credit == null) {
            errors.put(fieldCredit, "Не выбран кредит для погашения");
            return errors;
        }

        double monthlyPayment = credit.getMonthlyPayment();

        if (creditRepayment.getQuantityOfMoney() != monthlyPayment) {
            errors.put(fieldQuantityOfMoney, "Сумма не верна");
        }

        if (accountSender.getBalance() < monthlyPayment) {
            errors.put(fieldQuantityOfMoney, "На вашем счету недостаточно средств: " + accountSender.getBalance());
        }

        return errors;
    }
}
