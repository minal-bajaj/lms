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
public class Account {
    
    private final String accountIdentifier;
    private final String status;

    public Account() {
        this.accountIdentifier = null;
        this.status = null;
    }

    public Account(String accountIdentifier, String status) {
        this.accountIdentifier = accountIdentifier;
        this.status = status;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public String getStatus() {
        return status;
    }
    
    
}
