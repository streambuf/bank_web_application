package com.bank.mvc.utils;

import com.bank.mvc.models.ContributionRate;
import com.bank.mvc.models.enums.ListCurrency;
import com.bank.mvc.models.enums.ListPaymentProcedure;
import com.bank.mvc.models.enums.ListPeriod;
import com.bank.mvc.models.enums.ListQuantityOfMoney;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zalman on 22.05.2015.
 */
public class ViewHelper {

    public static List<List<String>> contributionRateToTable(List<ContributionRate> rates) {
        List<List<String>> table = new ArrayList<List<String>>();

        List<String> row = new ArrayList<>();
        row.add("");
        ListCurrency currency = null;
        for (ContributionRate rate : rates) {
            ListCurrency currentCurrency = rate.getCurrency();
            if (currency != currentCurrency) {
                row.set(0, enumCurrencyToString(currentCurrency));
                currency = currentCurrency;
            }

            if (rate.getListPeriod() == ListPeriod.M1_6) {
                row.add("от " + enumMoneyToString(rate.getQuantityOfMoney()));
            }
            row.add(String.valueOf(rate.getRate()) + "%");
            if (rate.getListPeriod() == ListPeriod.M24_36) {
                table.add(row);
                row = new ArrayList<>();
                row.add("");
            }
        }
        return table;
    }

    private static String enumCurrencyToString(ListCurrency currency) {
        switch (currency) {
            case RUBLE: return "руб.";
            case DOLLAR: return "$";
            case EUROS: return "€";
            default: return "ошибка";
        }
    }

    private static String enumMoneyToString(ListQuantityOfMoney listQuantityOfMoney) {
        switch (listQuantityOfMoney) {
            case M100: return "100";
            case M1000: return "1 000";
            case M3000: return "3 000";
            case M10000: return "10 000";
            case M20000: return "20 000";
            case M100000: return "100 000";
            case M2000000: return "200 000";
            case M400000: return "400 000";
            case M900000: return "900 000";
            default: return "ошибка";
        }
    }

}
