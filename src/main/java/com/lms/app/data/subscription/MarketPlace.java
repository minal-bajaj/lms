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
public class MarketPlace {
    private final String baseUrl;
    private final String partner;

    public MarketPlace() {
        this.baseUrl = null;
        this.partner = null;
    }

    public MarketPlace(String baseUrl, String partner) {
        this.baseUrl = baseUrl;
        this.partner = partner;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getPartner() {
        return partner;
    }
}
