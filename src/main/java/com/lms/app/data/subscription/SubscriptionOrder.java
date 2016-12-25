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
public class SubscriptionOrder {
    private final String type;
    private final MarketPlace marketPlace;
    private final Creator creator;
    private final Payload payload;

    public SubscriptionOrder(String type, MarketPlace marketPlace, Creator creator, Payload payload) {
        this.type = type;
        this.marketPlace = marketPlace;
        this.creator = creator;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public Creator getCreator() {
        return creator;
    }

    public Payload getPayload() {
        return payload;
    }
    
    
    
}
