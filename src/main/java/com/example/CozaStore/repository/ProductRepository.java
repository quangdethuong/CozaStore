package com.example.CozaStore.repository;


import com.example.CozaStore.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;


@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryId(int idCategory);

    List<ProductEntity> findProductByCategoryId(int idCategory);
}
