package com.example.CozaStore.controller;

import com.example.CozaStore.payload.BlogMonthDTO;
import com.example.CozaStore.payload.request.PagingRequest;
import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.imp.BlogServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogServiceImp blogServiceImp;

//    @GetMapping("")
//    public ResponseEntity<?> getAllAndPagingBlog(@RequestParam HashMap<String,String> hashMap){
//        int page = Integer.parseInt(hashMap.getOrDefault("page","0"));
//        int size = Integer.parseInt(hashMap.getOrDefault("size","3"));
//
//        return new ResponseEntity<>(blogServiceImp.getAllBlog(page, size), HttpStatus.OK);
//    }
    @PostMapping("")
    public ResponseEntity<?> getAllAndPagingBlog(
            @RequestBody PagingRequest pagingReq ){
//        int page = Integer.parseInt(hashMap.getOrDefault("page","0"));
//        int size = Integer.parseInt(hashMap.getOrDefault("size","3"));
        // default value
        int page = 0;
        int size = 3;

        // if in request body has json parameter --> PagingRequest auto map key value <> use default value
        if(pagingReq != null){
            page = pagingReq.getPage();
            size = pagingReq.getSize();
        }
        return new ResponseEntity<>(blogServiceImp.getAllBlog(page, size), HttpStatus.OK);
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<?> getAllBlogByTagId(@RequestParam HashMap<String,String> hashMap, @PathVariable int id){
        int page = Integer.parseInt(hashMap.getOrDefault("page","0"));
        int size = Integer.parseInt(hashMap.getOrDefault("size","3"));
        return new ResponseEntity<>(blogServiceImp.getAllBlogByTagId(id,page,size),HttpStatus.OK);
    }

    @GetMapping("/number")
    public ResponseEntity<?> getNumberOfBlogByMonth(){
        BlogMonthDTO dto = blogServiceImp.getNumberBlogByMonth();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


}
