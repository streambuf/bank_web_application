package com.bank.mvc.domain.service;

import com.bank.mvc.models.Contribution;
import com.bank.mvc.models.ContributionRate;

import java.util.Collection;

/**
 * Created by Zalman on 21.05.2015.
 */
public interface ContributionRateService {

    public Collection<ContributionRate> getAllContributionRates();

    public ContributionRate getContributionRateById(long contributionRateId);

    public void saveContributionRate(ContributionRate contributionRate);

    public void deleteContributionRate(ContributionRate contributionRate);

    public ContributionRate getRepaymentByContribution(Contribution contribution);

}
