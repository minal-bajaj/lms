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
public class Company {
    private final String country;
    private final String name;
    private final String phoneNumber;
    private final String uuid;
    private final String website;

    public Company(String country, String name, String phoneNumber, String uuid, String website) {
        this.country = country;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.uuid = uuid;
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public String getWebsite() {
        return website;
    }
    
    
    
    
}
