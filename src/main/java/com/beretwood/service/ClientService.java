package com.beretwood.service;

import com.beretwood.domain.Client;

public class ClientService {

    public Client createClient(String email) {
        email = email.trim();
        if (email.equals("")) {
            throw new IllegalArgumentException("Client email cannot be empty");
        } else {
            Client client = new Client(email.toLowerCase());
            return client;
        }
    }
}
