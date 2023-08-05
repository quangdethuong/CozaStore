package com.example.CozaStore.payload.request;

import com.example.CozaStore.payload.response.ProductResponse;

import java.util.List;

public class CartItemRequest {
    private List<ProductResponse> cartItems;
    private List<Integer> quantities;

    public CartItemRequest(List<ProductResponse> cartItems, List<Integer> quantities) {
        this.cartItems = cartItems;
        this.quantities = quantities;
    }

    public CartItemRequest() {
    }

    public List<ProductResponse> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ProductResponse> cartItems) {
        this.cartItems = cartItems;
    }


    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }
}
