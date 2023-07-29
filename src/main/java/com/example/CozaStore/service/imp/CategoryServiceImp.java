package com.example.CozaStore.service.imp;


import com.example.CozaStore.entity.ProductEntity;
import com.example.CozaStore.payload.response.CategoryResponse;

import java.util.List;

public interface CategoryServiceImp {
    List<CategoryResponse> getAllCategory();
}
