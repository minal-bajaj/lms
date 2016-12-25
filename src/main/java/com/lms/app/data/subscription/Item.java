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
public class Item {
    private final String quantity;
    private final String unit;

    public Item() {
        this.quantity = null;
        this.unit = null;
    }

    public Item(String quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
