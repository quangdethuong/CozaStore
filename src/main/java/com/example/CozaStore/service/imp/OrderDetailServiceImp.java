package com.example.CozaStore.service.imp;

import com.example.CozaStore.entity.OrderDetailEntity;
import com.example.CozaStore.entity.ProductEntity;
import com.example.CozaStore.payload.response.OrderDetailResponse;
import com.example.CozaStore.payload.response.ProductResponse;

import java.sql.Date;

public interface OrderDetailServiceImp {

    void createOrderDetail(ProductResponse product, int order_id, Date date, int quantity);
}
