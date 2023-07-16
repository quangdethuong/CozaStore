package com.example.CozaStore.service;


import com.example.CozaStore.entity.ProductEntity;
import com.example.CozaStore.payload.response.ProductResponse;
import com.example.CozaStore.repository.ProductRepository;
import com.example.CozaStore.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductResponse> getProductByCategory(int idC) {
        List<ProductEntity> list = productRepository.findByCategoryId(idC);
        List<ProductResponse> productResponseList = new ArrayList<>();

        for (ProductEntity data : list){
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setImage(data.getImage());
            productResponse.setPrice(data.getPrice());

            productResponseList.add(productResponse);
        }
        return productResponseList;
    }
}
