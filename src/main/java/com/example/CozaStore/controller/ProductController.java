package com.example.CozaStore.controller;



import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.payload.response.ProductResponse;
import com.example.CozaStore.service.imp.ImageServiceImp;
import com.example.CozaStore.service.imp.ProductServiceImp;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @Autowired
    private ImageServiceImp imageServiceImp;


    private Gson gson = new Gson();

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("")
    public ResponseEntity<?> getAllProduct(){
        List<ProductResponse> list = productServiceImp.getAllProduct();
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getAllProduct());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(
            @PathVariable int id
    ){
        ProductResponse productResponse = productServiceImp.getProductByID(id);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(productResponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductByCategory(
            @PathVariable int id) {
        logger.info("Tham so"+ id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(productServiceImp.getProductByCategory(id));

        logger.info(gson.toJson(baseResponse));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/relateItem")
    public ResponseEntity<?> getRelatedItems(
            @RequestParam int categoryId,
            @RequestParam int currentProductId
    ){
        List<ProductResponse> list = productServiceImp.getProductsByCategoryId(categoryId, currentProductId);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
