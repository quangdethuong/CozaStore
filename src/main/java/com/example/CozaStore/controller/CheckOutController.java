package com.example.CozaStore.controller;

import com.example.CozaStore.entity.ProductEntity;
import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.payload.request.CartItemQuantityRequest;
import com.example.CozaStore.payload.request.CartItemRequest;
import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.payload.response.OrderResponse;
import com.example.CozaStore.payload.response.ProductResponse;
import com.example.CozaStore.payload.response.UserResponse;
import com.example.CozaStore.service.OrderDetailService;
import com.example.CozaStore.service.OrderService;
import com.example.CozaStore.service.ProductService;
import com.example.CozaStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkout")
@CrossOrigin(origins = "*")
public class CheckOutController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> checkoutOrder(
            @RequestBody CartItemRequest cartObj
            ){
        UserResponse user = userService.getUserById(cartObj.getUser_id());
        OrderResponse order = orderService.createOrder(user);
        List<ProductResponse> list = cartObj.getCartItems();
        List<Integer> quantities = cartObj.getQuantities();
        for(int i=0; i < list.size(); ++i){
            orderDetailService.createOrderDetail(list.get(i), order.getId(), order.getDate(), quantities.get(i));
        }
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData("Order Items Sucess");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
