package com.bank.mvc.domain.service;

import com.bank.mvc.models.OperationTransfer;

import java.util.Collection;

/**
 * Created by Zalman on 11.05.2015.
 */
public interface OperationTransferService {

    public Collection<OperationTransfer> getAllOperationTransfers();

    public OperationTransfer getOperationTransferById(long operationTransferId);

    public void saveOperationTransfer(OperationTransfer operationTransfer);

    public void deleteOperationTransfer(OperationTransfer operationTransfer);
}
