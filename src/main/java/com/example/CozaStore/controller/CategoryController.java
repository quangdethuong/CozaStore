package com.example.CozaStore.controller;


import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.imp.CategoryServiceImp;
import com.example.CozaStore.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @Autowired
    private ProductServiceImp productServiceImp;

    public ResponseEntity<?> clearCache(){
        return new ResponseEntity<>("", HttpStatus.OK);

    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategory(){
        BaseResponse response = new BaseResponse();
        response.setData(categoryServiceImp.getAllCategory());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<?>getProductByCategoryID(
            @RequestParam int id){
        BaseResponse response = new BaseResponse();
        response.setData(productServiceImp.getProductByCategory(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
