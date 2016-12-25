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
public class Creator {
    private final Address address;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String locale;
    private final String openId;
    private final String uuid;

    public Creator() {
        this.address = null;
        this.email = null;
        this.firstName = null;
        this.lastName = null;
        this.locale = null;
        this.openId = null;
        this.uuid = null;
    }
    
    public Creator(Address address, String email, String firstName, String lastName, String locale, String openId, String uuid) {
        this.address = address;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.locale = locale;
        this.openId = openId;
        this.uuid = uuid;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocale() {
        return locale;
    }

    public String getOpenId() {
        return openId;
    }

    public String getUuid() {
        return uuid;
    }
}
