package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.CreditDao;
import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.CreditService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.Credit;
import com.bank.mvc.models.enums.ListStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Zalman on 19.05.2015.
 */

@Service
public class CreditServiceImpl implements CreditService {

    private static double annualPercentageRate = 20;

    @Autowired
    private CreditDao creditDao;

    @Autowired
    private AccountService accountService;

    @Override
    public Credit getCreditById(long creditId) {
        return creditDao.getById(creditId);
    }

    @Override
    public Collection<Credit> getAllCredits() {
        return creditDao.getAll();
    }

    @Override
    public Collection<Credit> getAllUnconfirmedCredits() { return  creditDao.getAllUnconfirmed(); }

    @Override
    public Collection<Credit> getCreditsByUserId(long userId) {
        return creditDao.getByUserId(userId);
    }

    @Override
    public void saveCredit(Credit credit) {
        Account account = accountService.getAccountById(credit.getAccountId());
        credit.setAccount(account);
        credit.setAnnualPercentageRate(annualPercentageRate);
        credit.setStartDate(new Date());
        credit.setListStatus(ListStatus.UNCONFIRMED);
        double quantityOfMoney = credit.getQuantityOfMoney();
        double monthlyPayment = (quantityOfMoney*(annualPercentageRate/100/12))/(1-1/Math.pow((1+annualPercentageRate/100/12),credit.getPeriod()));
        credit.setMonthlyPayment(monthlyPayment);

        creditDao.save(credit);
    }

    @Override
    public void deleteCredit(Credit credit) {
        creditDao.delete(credit);
    }

    @Override
    public void confirmCredit(Credit credit) {
        Account account = credit.getAccount();
        double quantityOfMoney = credit.getQuantityOfMoney();
        account.setBalance(account.getBalance() + quantityOfMoney);
        accountService.saveAccount(account);
        credit.setListStatus(ListStatus.CONFIRMED);
        creditDao.save(credit);
    }
}
