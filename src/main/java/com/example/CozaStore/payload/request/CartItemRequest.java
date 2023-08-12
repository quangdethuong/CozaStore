package com.example.CozaStore.payload.request;

import com.example.CozaStore.payload.response.ProductResponse;

import java.util.List;

public class CartItemRequest {
    private int user_id;
    private List<ProductResponse> cartItems;
    private List<Integer> quantities;

    public CartItemRequest(List<ProductResponse> cartItems, List<Integer> quantities) {
        this.cartItems = cartItems;
        this.quantities = quantities;
    }

    public CartItemRequest(int user_id, List<ProductResponse> cartItems, List<Integer> quantities) {
        this.user_id = user_id;
        this.cartItems = cartItems;
        this.quantities = quantities;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
