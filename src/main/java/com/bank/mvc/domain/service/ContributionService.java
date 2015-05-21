package com.bank.mvc.domain.service;

import com.bank.mvc.models.Contribution;

import java.util.Collection;

/**
 * Created by Zalman on 21.05.2015.
 */
public interface ContributionService {
    public Collection<Contribution> getAllContributions();

    public Contribution getContributionById(long contributionId);

    public void saveContribution(Contribution contribution);

    public void deleteContribution(Contribution contribution);

}
