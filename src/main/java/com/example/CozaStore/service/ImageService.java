package com.example.CozaStore.service;

import com.example.CozaStore.entity.ImageEntity;
import com.example.CozaStore.payload.response.ImageResponse;
import com.example.CozaStore.repository.ImageRepository;
import com.example.CozaStore.service.imp.ImageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements ImageServiceImp {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ImageResponse findById(int idImage) {
        ImageEntity image = imageRepository.findById(idImage);
        ImageResponse response = new ImageResponse();
        response.setId(image.getId());
        response.setImage1(response.getImage1());
        response.setImage2(response.getImage2());
        response.setImage3(response.getImage3());

        return response;
    }
}
