package com.beretwood.domain;

import java.util.List;

public class Client {

    private String email;
    private List<Order> orders;

    public Client(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
