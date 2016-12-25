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
public class SubscriptionOrderStatus {
    private final String success;
    
    
    private final String accountIdentifier;
    
    
    private final String errorCode;
    private final String message;

    private SubscriptionOrderStatus(String success, String accountIdentifier, String errorCode, String message) {
        this.success = success;
        this.accountIdentifier = accountIdentifier;
        this.errorCode = errorCode;
        this.message = message;
    }
    
    public static class SuccessBuilder {
        
        String accountIdentifier;
        
        public SuccessBuilder accountIdentifier(String accountIdentifier) {
            this.accountIdentifier = accountIdentifier;
            return this;
        }
        
        public SubscriptionOrderStatus build() {
            return new SubscriptionOrderStatus("true", this.accountIdentifier, null, null);
        }
    }
    
    public static class ErrorBuilder {
        String errorCode;
        String message;
        
        public ErrorBuilder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }
        
        public ErrorBuilder message(String message) {
            this.message = message;
            return this;
        }
        
        public SubscriptionOrderStatus build() {
            return new SubscriptionOrderStatus("true", null, this.errorCode, this.message);
        }
    }

    public String getSuccess() {
        return success;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}