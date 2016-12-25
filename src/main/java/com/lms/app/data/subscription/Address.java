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
    private final String firstName;
    private final String fullName;
    private final String lastName;

    public Address(String firstName, String fullName, String lastName) {
        this.firstName = firstName;
        this.fullName = fullName;
        this.lastName = lastName;
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
}