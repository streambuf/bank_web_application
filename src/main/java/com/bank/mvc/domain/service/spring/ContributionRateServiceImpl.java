package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.ContributionRateDao;
import com.bank.mvc.domain.service.ContributionRateService;
import com.bank.mvc.models.ContributionRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zalman on 21.05.2015.
 */

@Service
public class ContributionRateServiceImpl implements ContributionRateService {

    @Autowired
    private ContributionRateDao contributionRateDao;

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
}
