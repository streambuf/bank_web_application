package com.bank.mvc.dao;

import com.bank.mvc.models.Client;

import java.util.Collection;

public interface ClientDao {

    public Collection<Client> getAll();

    public Client getById(int clientId);

    public void save(Client client);

    public void delete(Client client);

}
