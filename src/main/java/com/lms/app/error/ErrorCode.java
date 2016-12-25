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
public enum ErrorCode {
    
    USER_ALREADY_EXISTS("User already exists"),
    MAX_USERS_REACHED("max users reached"),
    USER_NOT_FOUND("user not found");
    
    private String message;
    
    private ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
