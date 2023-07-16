package com.example.CozaStore.service.imp;


import com.example.CozaStore.payload.request.SignupRequest;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);
}
