/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.data.subscription;

/**
 *
 * @author Minal
 */
public class Payload {
    private final Company company;
    private final Order order;
    private final Account account;

    public Payload() {
        this.company = null;
        this.order = null;
        this.account = null;
    }

    public Payload(Company company, Order order, Account account) {
        this.company = company;
        this.order = order;
        this.account = account;
    }

    public Company getCompany() {
        return company;
    }

    public Order getOrder() {
        return order;
    }

    public Account getAccount() {
        return account;
    }
    
    
}
