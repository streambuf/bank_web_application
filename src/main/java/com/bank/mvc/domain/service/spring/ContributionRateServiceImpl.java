package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.ContributionRateDao;
import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.ContributionRateService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.Contribution;
import com.bank.mvc.models.ContributionRate;
import com.bank.mvc.models.enums.ListCurrency;
import com.bank.mvc.models.enums.ListPeriod;
import com.bank.mvc.models.enums.ListQuantityOfMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Zalman on 21.05.2015.
 */

@Service
public class ContributionRateServiceImpl implements ContributionRateService {

    @Autowired
    private ContributionRateDao contributionRateDao;

    @Autowired
    private AccountService accountService;

    @Override
    public ContributionRate getContributionRateById(long contributionRateId) {
        return contributionRateDao.getById(contributionRateId);
    }

    @Override
    public Collection<ContributionRate> getAllContributionRates() {
        return contributionRateDao.getAll();
    }

    @Override
    public void saveContributionRate(ContributionRate contributionRate) {
        contributionRateDao.save(contributionRate);
    }

    @Override
    public void deleteContributionRate(ContributionRate contributionRate) {
        contributionRateDao.delete(contributionRate);
    }

    @Override
    public ContributionRate getRepaymentByContribution(Contribution contribution) {
        List<ContributionRate> rates = (ArrayList<ContributionRate>)getAllContributionRates();

        Account account =   accountService.getAccountById(contribution.getAccountId());

        if (account == null) {
            return null;
        }
        ListCurrency currency = account.getCurrency();
        double money = contribution.getQuantityOfMoney();
        if (currency == ListCurrency.RUBLE && money < 1000) {
            return null;
        } else if ((currency == ListCurrency.DOLLAR || currency == ListCurrency.EUROS) && money < 100) {
            return null;
        }

        int period = contribution.getPeriod();
        if (period < 1 || period > 36) {
            return null;
        }

        ListPeriod enumPeriod = null;
        if (isBetween(period, 1, 6)) {
            enumPeriod = ListPeriod.M1_6;
        } else if (isBetween(period, 6, 12)) {
            enumPeriod = ListPeriod.M6_12;
        } else if (isBetween(period, 12, 24)) {
            enumPeriod = ListPeriod.M12_24;
        } else if (isBetween(period, 24, 36)) {
            enumPeriod = ListPeriod.M24_36;
        }

        ListQuantityOfMoney enumMoney = null;
        if (currency == ListCurrency.RUBLE && isBetween(money, 1000, 100000)) {
            enumMoney = ListQuantityOfMoney.M1000;
        } else if (currency == ListCurrency.RUBLE && isBetween(money, 100000, 400000)) {
            enumMoney = ListQuantityOfMoney.M10000;
        } else if (currency == ListCurrency.RUBLE && isBetween(money, 400000, 900000)) {
            enumMoney = ListQuantityOfMoney.M400000;
        } else if (currency == ListCurrency.RUBLE && isBetween(money, 900000, 2000000)) {
            enumMoney = ListQuantityOfMoney.M900000;
        } else if (currency == ListCurrency.RUBLE && money > 2000000) {
            enumMoney = ListQuantityOfMoney.M2000000;
        } else if (isBetween(money, 100, 3000)) {
            enumMoney = ListQuantityOfMoney.M100;
        } else if (isBetween(money, 3000, 10000)) {
            enumMoney = ListQuantityOfMoney.M3000;
        } else if (isBetween(money, 10000, 20000)) {
            enumMoney = ListQuantityOfMoney.M10000;
        } else if (isBetween(money, 20000, 100000)) {
            enumMoney = ListQuantityOfMoney.M20000;
        } else if (money > 100000) {
            enumMoney = ListQuantityOfMoney.M100000;
        }



        for (ContributionRate rate : rates) {
            if (rate.getCurrency() == currency && rate.getListPeriod() == enumPeriod && rate.getQuantityOfMoney() == enumMoney) {
                return rate;
            }
        }
        return null;
    }

    private static boolean isBetween(double x, double lower, double upper) {
        return lower <= x && x <= upper;
    }

}
