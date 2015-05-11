package com.bank.mvc.dao;

import com.bank.mvc.models.OperationTransfer;

import java.util.Collection;

/**
 * Created by Zalman on 11.05.2015.
 */
public interface OperationTransferDao {

    public Collection<OperationTransfer> getAll();

    public OperationTransfer getById(long operationTransferId);

    public void save(OperationTransfer operationTransfer);

    public void delete(OperationTransfer operationTransfer);

}
