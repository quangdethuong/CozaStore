package com.example.CozaStore.service.imp;

import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.payload.response.OrderResponse;
import com.example.CozaStore.payload.response.UserResponse;

public interface OrderServiceImp {
    OrderResponse createOrder(UserResponse user);
}
