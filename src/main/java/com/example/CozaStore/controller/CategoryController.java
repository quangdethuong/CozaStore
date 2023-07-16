package com.example.CozaStore.controller;


import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;


    public ResponseEntity<?> clearCache(){
        return new ResponseEntity<>("", HttpStatus.OK);

    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategory(){
        BaseResponse response = new BaseResponse();
        response.setData(categoryServiceImp.getAllCategory());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}