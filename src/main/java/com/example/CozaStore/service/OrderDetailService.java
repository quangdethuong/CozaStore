package com.example.CozaStore.service;

import com.example.CozaStore.entity.OrderDetailEntity;
import com.example.CozaStore.entity.ProductEntity;
import com.example.CozaStore.entity.ids.OrderDetailIds;
import com.example.CozaStore.payload.response.OrderDetailResponse;
import com.example.CozaStore.payload.response.ProductResponse;
import com.example.CozaStore.repository.OrderDetailRepository;
import com.example.CozaStore.service.imp.OrderDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrderDetailService implements OrderDetailServiceImp {
    @Autowired
    OrderDetailRepository orderDetailRepository;


    @Override
    public void createOrderDetail(ProductResponse product, int order_id, Date date, int quantity) {
        OrderDetailEntity entity = new OrderDetailEntity();
        OrderDetailIds ids = new OrderDetailIds();
        ids.setOrderId(order_id);
        ids.setProductId(product.getId());
        entity.setIds(ids);
        entity.setPrice(product.getPrice());
        entity.setQuantity(quantity);
        orderDetailRepository.save(entity);
    }
}
