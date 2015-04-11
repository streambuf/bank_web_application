package com.bank.mvc.domain.validation;

import com.bank.mvc.models.Client;
import com.bank.mvc.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ClientValidator {

    @Autowired
    ClientService clientService;

    public void validate(Client client, Errors errors) {
        if (client.getLname() == "test") {
            errors.rejectValue("lname", "validation.negative", "must be real");
        }
    }
}
