package com.example.CozaStore.service;


import com.example.CozaStore.entity.ImageEntity;
import com.example.CozaStore.entity.ProductEntity;
import com.example.CozaStore.payload.response.*;
import com.example.CozaStore.repository.ImageRepository;
import com.example.CozaStore.repository.ProductRepository;
import com.example.CozaStore.service.imp.ProductServiceImp;
import com.google.gson.Gson;
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
            // init resp obj
            ProductResponse productResponse = new ProductResponse();
            ImageResponse imageResponse = new ImageResponse();

            // map value to product DAO
            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setPrice(data.getPrice());

            // map value to image DAO
            imageResponse.setId(data.getImage().getId());
            imageResponse.setImage1(data.getImage().getImage1());
            imageResponse.setImage2(data.getImage().getImage2());
            imageResponse.setImage3(data.getImage().getImage3());

            // set image entity to product DAO
            productResponse.setImage(imageResponse);
            // add product DAO to resp list
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<ProductEntity> list = productRepository.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();


        for(ProductEntity data : list){
            // init value
            ProductResponse productResponse = new ProductResponse();
            ImageResponse image = new ImageResponse();

            // map value from result set to product DAO
            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setPrice(data.getPrice());

            // check exist image entity
            if(data.getImage() != null){
                // map value from result set to image DAO
                image.setId(data.getImage().getId());
                image.setImage1(data.getImage().getImage1());
                image.setImage2(data.getImage().getImage2());
                image.setImage3(data.getImage().getImage3());
            }

            // set image entity to product DAO
            productResponse.setImage(image);

            // add new product DAO to resp list
            productResponseList.add(productResponse);
        }

        return productResponseList;
    }

    @Override
    public ProductResponse getProductByID(int id) {
        // get ProductEntity by product Repository
        ProductEntity product = productRepository.getById(id);

        // init value
        ProductResponse response = new ProductResponse();
        ImageResponse imageResponse = new ImageResponse();
        SizeResponse sizeResponse = new SizeResponse();
        ColorResponse colorResponse = new ColorResponse();
        CategoryResponse categoryResponse = new CategoryResponse();

        // map result to product DAO
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setDescription(product.getDescription());

        // map Image Entity to Image DAO
        imageResponse.setId(product.getImage().getId());
        imageResponse.setImage1(product.getImage().getImage1());
        imageResponse.setImage2(product.getImage().getImage2());
        imageResponse.setImage3(product.getImage().getImage3());

        // map Size Entity to Size DAO
        sizeResponse.setId(product.getSize().getId());
        sizeResponse.setName(product.getSize().getName());

        // map Color Entity to Color DAO
        colorResponse.setId(product.getColor().getId());
        colorResponse.setName(product.getColor().getName());

        // map Category Entity to Category DAO
        categoryResponse.setId(product.getCategory().getId());
        categoryResponse.setName(product.getCategory().getName());

        // set image DAO to product DAO
        response.setImage(imageResponse);
        // set size DAO to product DAO
        response.setSize(sizeResponse);
        // set color DAO to product DAO
        response.setColor(colorResponse);
        // set categoryDAO to productDAO
        response.setCategory(categoryResponse);

        return response;
    }

    @Override
    public List<ProductResponse> getProductsByCategoryId(int categoryId, int currentProduct) {
        List<ProductEntity> list = productRepository.findProductByCategoryId(categoryId);
        List<ProductResponse> responses = new ArrayList<>();

        int count = 0;
        for(ProductEntity pEntity : list){
            ++count;
            ImageResponse imageResponse = new ImageResponse(
                    pEntity.getImage().getId(),
                    pEntity.getImage().getImage1(),
                    pEntity.getImage().getImage2(),
                    pEntity.getImage().getImage3());

            SizeResponse sizeResponse = new SizeResponse(
                    pEntity.getSize().getId(),
                    pEntity.getSize().getName()
            );
            ColorResponse colorResponse = new ColorResponse(
                    pEntity.getColor().getId(),
                    pEntity.getColor().getName()
            );
            CategoryResponse categoryResponse = new CategoryResponse(
                    pEntity.getCategory().getId(),
                    pEntity.getCategory().getName()
            );

            if(pEntity.getId() != currentProduct){
                responses.add(new ProductResponse(
                        pEntity.getId(),
                        pEntity.getName(),
                        pEntity.getPrice(),
                        pEntity.getDescription(),
                        imageResponse,
                        sizeResponse,
                        colorResponse,
                        categoryResponse
                ));
            }

            if(count == 4){
                return responses;
            }
        }

        return responses;
    }
}
