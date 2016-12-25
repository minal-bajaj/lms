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
public class Address {
    private final String city;
    private final String country;
    private final String firstName;
    private final String fullName;
    private final String lastName;
    private final String phone;
    private final String state;
    private final String street1;
    private final String street2;
    private final String zip;

    public Address() {
        this.city = null;
        this.country = null;
        this.firstName = null;
        this.fullName = null;
        this.lastName = null;
        this.phone = null;
        this.state = null;
        this.street1 = null;
        this.street2 = null;
        this.zip = null;
    }

    public Address(String city, String country, String firstName, String fullName, String lastName, String phone, String state, String street1, String street2, String zip) {
        this.city = city;
        this.country = country;
        this.firstName = firstName;
        this.fullName = fullName;
        this.lastName = lastName;
        this.phone = phone;
        this.state = state;
        this.street1 = street1;
        this.street2 = street2;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getState() {
        return state;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getZip() {
        return zip;
    }
}