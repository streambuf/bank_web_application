package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.ContributionDao;
import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.ContributionRateService;
import com.bank.mvc.domain.service.ContributionService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.Contribution;
import com.bank.mvc.models.ContributionRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Zalman on 21.05.2015.
 */

@Service
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    private ContributionDao contributionDao;

    @Autowired
    AccountService accountService;

    @Autowired
    private ContributionRateService contributionRateService;

    @Override
    public Contribution getContributionById(long contributionId) {
        return contributionDao.getById(contributionId);
    }

    @Override
    public Collection<Contribution> getAllContributions() {
        return contributionDao.getAll();
    }

    @Override
    public void saveContribution(Contribution contribution) {

        Account account = accountService.getAccountById(contribution.getAccountId());
        contribution.setAccount(account);
        contribution.setStartDate(new Date());

        ContributionRate contributionRate = contributionRateService.getRepaymentByContribution(contribution);

        contribution.setContributionRate(contributionRate);

        double money = contribution.getQuantityOfMoney();
        account.setBalance(account.getBalance() - money);
        accountService.saveAccount(account);

        contributionDao.save(contribution);
    }

    @Override
    public void deleteContribution(Contribution contribution) {
        contributionDao.delete(contribution);
    }
}
