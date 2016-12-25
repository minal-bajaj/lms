/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.db.dao;

import com.lms.app.data.subscription.SubscriptionOrder;
import com.lms.app.data.subscription.SubscriptionOrderStatus;
import com.lms.app.db.DataStore;
import com.lms.app.error.SubscriptionException;

/**
 *
 * @author Minal
 */
public class SubscriptionDAO {
    
    public SubscriptionOrderStatus create(SubscriptionOrder subscriptionOrder) {
        
        try {
            String uniqueId = DataStore.INSTANCE.put(subscriptionOrder);
            
            return new SubscriptionOrderStatus.SuccessBuilder()
                    .accountIdentifier(uniqueId).build();
        } catch (SubscriptionException ex) {
            return new SubscriptionOrderStatus.ErrorBuilder()
                    .errorCode(ex.getErrorCode().toString())
                    .message(ex.getErrorCode().getMessage()).build();
        }
    }
    
    public SubscriptionOrderStatus cancel(SubscriptionOrder order) {
        
        try {
            DataStore.INSTANCE.remove(order.getPayload().getAccount().getAccountIdentifier());
            
            return new SubscriptionOrderStatus.SuccessBuilder()
                    .accountIdentifier(order.getPayload().getAccount().getAccountIdentifier()).build();
        } catch (SubscriptionException ex) {
            return new SubscriptionOrderStatus.ErrorBuilder()
                    .errorCode(ex.getErrorCode().toString())
                    .message(ex.getErrorCode().getMessage()).build();
        }
    }
}