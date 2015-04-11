package com.bank.mvc.controllers;

import com.bank.mvc.models.Client;
import com.bank.mvc.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class MainController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    @ModelAttribute("clients")
    public Collection<Client> getClients2() {
        return null;
    }

    @RequestMapping(value = "/clientList", method = {RequestMethod.GET, RequestMethod.HEAD})
    @ModelAttribute("clients")
    public Collection<Client> getClients() {
        return clientService.getAllClients();
    }

    @RequestMapping("/clientDetails")
    public Client getClient(@RequestParam(value="id", required=true) int clientId) {
        return clientService.getClientById(clientId);
    }

}
