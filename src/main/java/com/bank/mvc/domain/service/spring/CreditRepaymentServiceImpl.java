package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.CreditRepaymentDao;
import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.CreditRepaymentService;
import com.bank.mvc.domain.service.CreditService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.CreditRepayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Zalman on 19.05.2015.
 */

@Service
public class CreditRepaymentServiceImpl implements CreditRepaymentService {

    @Autowired
    private CreditRepaymentDao creditRepaymentDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CreditService creditService;

    @Override
    public CreditRepayment getCreditRepaymentById(long creditRepaymentId) {
        return creditRepaymentDao.getById(creditRepaymentId);
    }

    @Override
    public Collection<CreditRepayment> getAllCreditRepayments() {
        return creditRepaymentDao.getAll();
    }

    @Override
    public void saveCreditRepayment(CreditRepayment creditRepayment) {

        creditRepaymentDao.save(creditRepayment);

        Account account = accountService.getAccountById(creditRepayment.getAccountId());
        creditRepayment.setAccount(account);
        creditRepayment.setOperationDate(new Date());
        creditRepayment.setCredit(creditService.getCreditById(creditRepayment.getCreditId()));


        double quantityOfMoney = creditRepayment.getQuantityOfMoney();
        account.setBalance(account.getBalance() - quantityOfMoney);
        accountService.saveAccount(account);

        creditRepaymentDao.save(creditRepayment);
    }

    @Override
    public void deleteCreditRepayment(CreditRepayment creditRepayment) {
        creditRepaymentDao.delete(creditRepayment);
    }

}
