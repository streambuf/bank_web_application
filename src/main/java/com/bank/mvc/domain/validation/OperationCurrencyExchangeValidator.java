package com.bank.mvc.domain.validation;

import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.OperationCurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zalman on 12.05.2015.
 */

@Component
public class OperationCurrencyExchangeValidator {

    @Autowired
    AccountService accountService;

    static String fieldAccountPayee = "accountPayeeError";
    static String fieldQuantityOfMoney = "quantityOfMoney";
    static String fieldAccountSender = "accountSenderError";
    static double minQuantityOfMoney = 1;
    static double maxQuantityOfMoney = 100000;

    public Map<String, String> validate(OperationCurrencyExchange operationCurrencyExchange) {

        Map<String, String> errors = new HashMap<>();

        long accountSenderId = operationCurrencyExchange.getAccountSenderId();
        long accountPayeeId = operationCurrencyExchange.getAccountPayeeId();

        if (accountPayeeId == accountSenderId) {
            errors.put(fieldAccountPayee, "Нельзя использовать один и тот же счет");
            return errors;
        }

        Account accountSender = accountService.getAccountById(accountSenderId);
        if (accountSender == null) {
            errors.put(fieldAccountSender, "Не выбран счет");
            return errors;
        }

        Account accountPayee = accountService.getAccountById(accountPayeeId);
        if (accountPayee == null) {
            errors.put(fieldAccountPayee, "Не выбран счет");
            return errors;
        }

        if (accountPayee.getCurrency().equals(accountSender.getCurrency())) {
            errors.put(fieldAccountPayee, "Валюта счетов должна быть разной, иначе воспользуйтесь обычным переводом");
            return errors;
        }

        double quantityOfMoney = operationCurrencyExchange.getQuantityOfMoney();
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
