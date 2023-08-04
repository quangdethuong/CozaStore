package com.example.CozaStore.service.imp;



import com.example.CozaStore.payload.response.ImageResponse;
import com.example.CozaStore.payload.response.ProductResponse;

import java.util.List;

public interface ProductServiceImp {
    List<ProductResponse> getProductByCategory(int idC);

    List<ProductResponse> getAllProduct();

    ProductResponse getProductByID(int id);

    List<ProductResponse> getProductsByCategoryId(int categoryId, int currentProduct);
}
