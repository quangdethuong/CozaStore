package com.example.CozaStore.service;

import com.example.CozaStore.entity.OrderEntity;
import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.payload.response.OrderResponse;
import com.example.CozaStore.payload.response.UserResponse;
import com.example.CozaStore.repository.OrderRepository;
import com.example.CozaStore.service.imp.OrderServiceImp;
import com.example.CozaStore.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class OrderService implements OrderServiceImp {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderResponse createOrder(UserResponse user) {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        UserEntity userEntity = new UserEntity(user.getId(), user.getEmail(), user.getUserName());
        OrderEntity orderEntity = new OrderEntity();
        OrderResponse response = new OrderResponse();
        orderEntity.setDate(date);
        orderEntity.setUser(userEntity);
        orderRepository.save(orderEntity);

        List<OrderEntity> list = orderRepository.findAll();
        response.setId(list.get(list.size()-1).getId());
        response.setDate((Date) list.get(list.size()-1).getDate());

        return response;
    }
}
