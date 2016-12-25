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
    private final MarketPlace marketplace;
    private final Creator creator;
    private final Payload payload;

    public SubscriptionOrder() {
        this.type = null;
        this.marketplace = null;
        this.creator = null;
        this.payload = null;
    }

    public SubscriptionOrder(String type, MarketPlace marketPlace, Creator creator, Payload payload) {
        this.type = type;
        this.marketplace = marketPlace;
        this.creator = creator;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public MarketPlace getMarketplace() {
        return marketplace;
    }

    public Creator getCreator() {
        return creator;
    }

    public Payload getPayload() {
        return payload;
    }
    
    
    
}
