package com.example.CozaStore.payload.request;

import java.util.List;

public class CartItemQuantityRequest {

    private List<Integer> quantities;

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }
}
