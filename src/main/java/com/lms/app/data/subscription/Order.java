/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.data.subscription;

import java.util.List;

/**
 *
 * @author Minal
 */
public class Order {
    private final String editionCode;
    private final String pricingDuration;
    private final List<Item> items;

    public Order() {
        this.editionCode = null;
        this.pricingDuration = null;
        this.items = null;
    }

    public Order(String editionCode, String pricingDuration, List<Item> items) {
        this.editionCode = editionCode;
        this.pricingDuration = pricingDuration;
        this.items = items;
    }

    public String getEditionCode() {
        return editionCode;
    }

    public String getPricingDuration() {
        return pricingDuration;
    }

    public List<Item> getItems() {
        return items;
    }
    
    
}
