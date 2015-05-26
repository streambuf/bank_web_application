package com.bank.mvc.domain.validation;

import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.Contribution;
import com.bank.mvc.models.enums.ListCurrency;
import com.bank.mvc.models.enums.ListPaymentProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zalman on 22.05.2015.
 */

@Component
public class ContributionValidator {
    @Autowired
    AccountService accountService;

    private static String fieldAccount = "accountError";
    static String fieldQuantityOfMoney = "quantityOfMoney";
    static String fieldPeriod = "period";
    static String fieldPaymentProcedure = "listPaymentProcedure";
    static double minQuantityOfMoney = 1;
    static double maxQuantityOfMoney = 10000000;

    public Map<String, String> validate(Contribution contribution) {

        Map<String, String> errors = new HashMap<>();

        long accountId = contribution.getAccountId();


        Account account = accountService.getAccountById(accountId);
        if (account == null) {
            errors.put(fieldAccount, "Не выбран счет");
            return errors;
        }

        ListCurrency currency = account.getCurrency();

        double money = contribution.getQuantityOfMoney();
        if (currency == ListCurrency.RUBLE && money < 1000) {
            errors.put(fieldQuantityOfMoney, "Минимальная сумма 1000 руб.");
        } else if ((currency == ListCurrency.DOLLAR || currency == ListCurrency.EUROS) && money < 100) {
            errors.put(fieldQuantityOfMoney, "Минимальная сумма 100$ или 100€");
        }

        int period = contribution.getPeriod();
        if (period < 1 || period > 36) {
            errors.put(fieldPeriod, "Вклад можно открыть на срок от 1 месяца до 3 лет (36 месяцев)");
        }

        ListPaymentProcedure listPaymentProcedure = contribution.getListPaymentProcedure();
        if (listPaymentProcedure == null) {
            errors.put(fieldPaymentProcedure, "Долже быть указан способ начисления процентов");
        }


        double quantityOfMoney = contribution.getQuantityOfMoney();
        if (quantityOfMoney < minQuantityOfMoney) {
            errors.put(fieldQuantityOfMoney, "Минимальная сумма составляет: " + minQuantityOfMoney);
        } else if (quantityOfMoney > maxQuantityOfMoney) {
            errors.put(fieldQuantityOfMoney, "Максимальная сумма составляет: " + maxQuantityOfMoney);
        } else if (account.getBalance() < quantityOfMoney) {
            errors.put(fieldQuantityOfMoney, "На вашем счету недостаточно средств: " + account.getBalance());
        }

        return errors;

    }
}
