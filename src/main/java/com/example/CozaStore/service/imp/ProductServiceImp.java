package com.example.CozaStore.service.imp;



import com.example.CozaStore.payload.response.ProductResponse;

import java.util.List;

public interface ProductServiceImp {
    List<ProductResponse> getProductByCategory(int idC);
}
