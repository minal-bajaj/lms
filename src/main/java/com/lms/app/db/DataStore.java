/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.db;

import com.lms.app.data.subscription.SubscriptionOrder;
import com.lms.app.error.ErrorCode;
import com.lms.app.error.SubscriptionException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Minal
 */
public enum DataStore {
    
    INSTANCE;
    
    private final int MAXIMUM_NUMBER_OF_ORDERS = 1000;
    
    private Set<String> users;
    private Map<String, SubscriptionOrder> orders;
    
    private DataStore() {
        users = new HashSet<>(MAXIMUM_NUMBER_OF_ORDERS);
        orders = new HashMap<>(MAXIMUM_NUMBER_OF_ORDERS);
    }
    
    public synchronized String put(SubscriptionOrder order) throws SubscriptionException {
        
        if (this.users.contains(order.getCreator().getEmail())) {
            throw new SubscriptionException(ErrorCode.USER_ALREADY_EXISTS);
        }
        
        if (orders.size() > MAXIMUM_NUMBER_OF_ORDERS) {
            throw new SubscriptionException(ErrorCode.MAX_USERS_REACHED);
        }
        
        String uniqueId = String.valueOf(orders.size() + 1);
        
        this.users.add(order.getCreator().getEmail());
        this.orders.put(uniqueId, order);
        return uniqueId;
    }
    
    public SubscriptionOrder get(String uniqueId) {
        return orders.get(uniqueId);
    }
    
    public synchronized SubscriptionOrder remove(String uniqueId) throws SubscriptionException{
        
        SubscriptionOrder order = this.orders.remove(uniqueId);
        
        if (order == null) {
            throw new SubscriptionException(ErrorCode.USER_NOT_FOUND);
        }
        
        this.users.remove(order.getCreator().getEmail());
        
        return order;
    }
}