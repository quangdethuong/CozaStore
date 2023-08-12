package com.example.CozaStore.service.imp;


import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.payload.request.SignupRequest;
import com.example.CozaStore.payload.response.ProductResponse;
import com.example.CozaStore.payload.response.UserResponse;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);

    UserResponse getUserByEmail(String email);

    UserResponse getUserById(int userId);
}
