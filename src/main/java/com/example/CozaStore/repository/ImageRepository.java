package com.example.CozaStore.repository;

import com.example.CozaStore.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
    ImageEntity findById(int idImage);
}
