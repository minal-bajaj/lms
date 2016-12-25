/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.error;

/**
 *
 * @author Minal
 */
public class SubscriptionException extends Exception {
    
    private ErrorCode errorCode;

    public SubscriptionException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}