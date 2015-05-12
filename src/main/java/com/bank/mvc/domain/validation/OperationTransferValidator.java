package com.bank.mvc.domain.validation;

import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.OperationTransfer;
import com.bank.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zalman on 11.05.2015.
 */

@Component
public class OperationTransferValidator extends AbstractValidator {

    @Autowired
    AccountService accountService;

    static String fieldAccountPayee = "accountPayee";
    static String fieldQuantityOfMoney = "quantityOfMoney";
    static String fieldAccountSender = "accountSenderError";
    static int maxLengthAccountPayee = 19;
    static double minQuantityOfMoney = 1;
    static double maxQuantityOfMoney = 100000;

    public Map<String, String> validate(OperationTransfer operationTransfer) {

        Map<String, String> errors = new HashMap<>();

        // num digits in accountPayee
        int lengthAccountPayee = (int) Math.log10(operationTransfer.getAccountPayee()) + 1;
        if (lengthAccountPayee != maxLengthAccountPayee) {
            errors.put(fieldAccountPayee, "Неверный номер счета");
        }

        long accountSenderId = operationTransfer.getAccountSenderId();
        Account accountSender = accountService.getAccountById(operationTransfer.getAccountSenderId());
        if (accountSender == null) {
            errors.put(fieldAccountSender, "Не выбран счет списания");
            return errors;
        }

        Account accountPayee = accountService.getAccountById(operationTransfer.getAccountPayee());
        if (accountPayee!= null && !accountPayee.getCurrency().equals(accountSender.getCurrency())) {
            errors.put(fieldAccountPayee, "Валюты счетов не совпадают: " + accountPayee.getCurrency());
            return errors;
        }

        double quantityOfMoney = operationTransfer.getQuantityOfMoney();
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
